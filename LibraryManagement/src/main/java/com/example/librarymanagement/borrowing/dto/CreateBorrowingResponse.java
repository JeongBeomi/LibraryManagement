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
    String email;
    Long booksId;
    String title;
    LocalDateTime borrowAt;

    public static CreateBorrowingResponse create(Books books, User user, Borrowing borrowing) {
        return CreateBorrowingResponse.builder()
                .email(user.getEmail())
                .booksId(books.getId())
                .title(books.getTitle())
                .borrowAt(borrowing.getBorrowAt())
                .build();
    }
}
