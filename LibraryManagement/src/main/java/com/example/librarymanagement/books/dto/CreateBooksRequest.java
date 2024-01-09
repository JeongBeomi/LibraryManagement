package com.example.librarymanagement.books.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBooksRequest {
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private String isbn;
}
