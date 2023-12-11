package com.example.librarymanagement.borrowing.entity;

import com.example.librarymanagement.book.entity.Books;
import com.example.librarymanagement.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="borrowing")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    private Long id;

    @CreatedDate
    @NotNull
    private LocalDateTime borrowDate;

    private LocalDateTime returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "books_id")
    private Books books;

    //==비즈니스 로직==//

    //생성 메서드
    public static Borrowing create(User user, Books book) {
        return Borrowing.builder()
                .user(user)
                .books(book)
                .build();
    }

    /**
     * 반날날짜를 현재시간으로 변경
     */
    public void updateReturnDate() {
        this.returnDate = LocalDateTime.now();
    }
}
