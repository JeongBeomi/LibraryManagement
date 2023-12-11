package com.example.librarymanagement.books.dto;

import com.example.librarymanagement.books.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class CreateBooksResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDateTime createdAt;

    public static CreateBooksResponse create(Books books) {
        return CreateBooksResponse.builder()
                .id(books.getId())
                .title(books.getTitle())
                .author(books.getAuthor())
                .isbn(books.getIsbn())
                .createdAt(books.getCreatedAt())
                .build();

    }
}
