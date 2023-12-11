package com.example.librarymanagement.book.entity;

import com.example.librarymanagement.util.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="books")
public class Books extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "books_id")
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    @NotNull
    private boolean isBorrowing;

    //==비즈니스 로직==//

    //생성 메서드
    public static Books create(String title, String author, String isbn) {
        return Books.builder()
                .title(title)
                .author(author)
                .isbn(isbn)
                .isBorrowing(true)
                .build();

    }

}
