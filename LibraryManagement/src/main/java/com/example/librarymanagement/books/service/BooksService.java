package com.example.librarymanagement.books.service;

import com.example.librarymanagement.books.dto.CreateBooksRequest;
import com.example.librarymanagement.books.dto.CreateBooksResponse;

public interface BooksService {
    /**
     * 책 등록
     * @param request CreateBooksRequest
     * @return CreateBooksResponse
     */
    CreateBooksResponse createBooks(CreateBooksRequest request);
}
