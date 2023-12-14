package com.example.librarymanagement.borrowing.dto;

import com.example.librarymanagement.borrowing.entity.Borrowing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ReadBorrowingInstance {
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ReadBorrowingInstance create(String email, Borrowing borrowing) {
        return ReadBorrowingInstance.builder()
                .email(email)
                .createdAt(borrowing.getCreatedAt())
                .updatedAt(borrowing.getUpdatedAt())
                .build();
    }
}
