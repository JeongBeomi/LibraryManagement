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
public class CreateBorrowingResponse {
    private Long borrowingId;
    private String email;
    private Long booksId;
    private String title;
    private LocalDateTime createdAt;

    public static CreateBorrowingResponse create(Books books, User user, Borrowing borrowing) {
        return CreateBorrowingResponse.builder()
                .borrowingId(borrowing.getId())
                .email(user.getEmail())
                .booksId(books.getId())
                .title(books.getTitle())
                .createdAt(borrowing.getCreatedAt())
                .build();
    }
}
