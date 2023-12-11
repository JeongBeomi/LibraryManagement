package com.example.librarymanagement.books.dto;

import com.example.librarymanagement.books.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class UpdateBooksResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDateTime createAt;

    public static UpdateBooksResponse create(Books books) {
        return UpdateBooksResponse.builder()
                .id(books.getId())
                .title(books.getTitle())
                .author(books.getAuthor())
                .isbn(books.getIsbn())
                .createAt(books.getCreatedAt())
                .build();

    }
}
