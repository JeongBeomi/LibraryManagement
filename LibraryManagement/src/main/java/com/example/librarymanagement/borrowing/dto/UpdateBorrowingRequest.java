package com.example.librarymanagement.borrowing.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBorrowingRequest {
    @NotNull
    private Long booksId;
}
