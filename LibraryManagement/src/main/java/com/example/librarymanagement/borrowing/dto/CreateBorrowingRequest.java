package com.example.librarymanagement.borrowing.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBorrowingRequest {
    @NotNull
    private String email;
    @NotNull
    private Long booksId;
}
