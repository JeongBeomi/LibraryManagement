package com.example.librarymanagement.books.entity;

import com.example.librarymanagement.books.dto.UpdateBooksRequest;
import com.example.librarymanagement.util.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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
                .isBorrowing(false)
                .build();

    }

    // 책정보 수정
    public Books updateBooks(UpdateBooksRequest request) {
        if (request.getTitle() != null) {
            this.title = request.getTitle();
        }
        if (request.getAuthor() != null) {
            this.author = request.getAuthor();
        }
        if (request.getIsbn() != null) {
            this.isbn = request.getIsbn();
        }
        return this;
    }

    // 책 대여나 반납시 상태 변경
    public Books updateIsBorrowing() {
        this.isBorrowing = !this.isBorrowing;
        return this;
    }

}
