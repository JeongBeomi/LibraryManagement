package com.example.librarymanagement.books.service;

import com.example.librarymanagement.books.dto.CreateBooksRequest;
import com.example.librarymanagement.books.dto.CreateBooksResponse;
import com.example.librarymanagement.books.dto.UpdateBooksRequest;
import com.example.librarymanagement.books.dto.UpdateBooksResponse;

public interface BooksService {
    /**
     * 책 등록
     * @param request CreateBooksRequest
     * @return CreateBooksResponse
     */
    CreateBooksResponse createBooks(CreateBooksRequest request);

    /**
     * 책정보 수정 *
     * @param request UpdateBooksRequest
     * @param booksId booksId
     * @return UpdateBooksResponse
     */
    UpdateBooksResponse updateBooks(UpdateBooksRequest request, Long booksId);
}
