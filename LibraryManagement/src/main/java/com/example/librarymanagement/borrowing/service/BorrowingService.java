package com.example.librarymanagement.borrowing.service;

import com.example.librarymanagement.books.dto.UpdateBooksRequest;
import com.example.librarymanagement.books.dto.UpdateBooksResponse;
import com.example.librarymanagement.borrowing.dto.CreateBorrowingRequest;
import com.example.librarymanagement.borrowing.dto.CreateBorrowingResponse;

public interface BorrowingService {
    CreateBorrowingResponse createBorrowing(CreateBorrowingRequest request);
}
