package com.example.librarymanagement.borrowing.dto;

import lombok.Data;

@Data
public class CreateBorrowingRequest {
    private String email;
    private Long booksId;
}
