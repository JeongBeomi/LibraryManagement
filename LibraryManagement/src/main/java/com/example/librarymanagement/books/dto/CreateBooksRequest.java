package com.example.librarymanagement.books.dto;

import lombok.Data;

@Data
public class CreateBooksRequest {
    private String title;
    private String author;
    private String isbn;
}
