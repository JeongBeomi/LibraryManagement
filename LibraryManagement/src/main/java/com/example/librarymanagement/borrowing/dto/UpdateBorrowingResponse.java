package com.example.librarymanagement.borrowing.dto;

import com.example.librarymanagement.books.entity.Books;
import com.example.librarymanagement.borrowing.entity.Borrowing;
import com.example.librarymanagement.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class UpdateBorrowingResponse {
    private Long booksId;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UpdateBorrowingResponse create(Books books, Borrowing borrowing) {
        return UpdateBorrowingResponse.builder()
                .booksId(books.getId())
                .title(books.getTitle())
                .createdAt(borrowing.getCreatedAt())
                .updatedAt(borrowing.getUpdatedAt())
                .build();
    }
}
