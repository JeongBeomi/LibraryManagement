package com.example.librarymanagement.borrowing.service;

import com.example.librarymanagement.books.dto.UpdateBooksRequest;
import com.example.librarymanagement.books.dto.UpdateBooksResponse;
import com.example.librarymanagement.borrowing.dto.*;

public interface BorrowingService {
    /**
     * 대여 메서드
     * @param request CreateBorrowingRequest
     * @return CreateBorrowingResponse
     */
    CreateBorrowingResponse createBorrowing(CreateBorrowingRequest request);

    /**
     * 반납 메서드
     * @param request UpdateBorrowingRequest
     * @return UpdateBorrowingResponse
     */
    UpdateBorrowingResponse updateBorrowing(UpdateBorrowingRequest request);

    ReadBorrowingResponse readBorrowingList(ReadBorrowingRequest request);
}
