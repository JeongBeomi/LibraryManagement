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
    private LocalDateTime updatedAt;

    public static UpdateBooksResponse create(Books books) {
        return UpdateBooksResponse.builder()
                .id(books.getId())
                .title(books.getTitle())
                .author(books.getAuthor())
                .isbn(books.getIsbn())
                .updatedAt(books.getUpdatedAt())
                .build();

    }
}
