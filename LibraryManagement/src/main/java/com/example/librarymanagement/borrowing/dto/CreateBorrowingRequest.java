package com.example.librarymanagement.borrowing.dto;

import lombok.Data;

@Data
public class CreateBorrowingRequest {
    String email;
    Long booksId;
}
