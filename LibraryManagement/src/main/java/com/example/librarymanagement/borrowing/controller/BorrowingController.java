package com.example.librarymanagement.borrowing.controller;

import com.example.librarymanagement.borrowing.dto.*;
import com.example.librarymanagement.borrowing.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/borrowing")
public class BorrowingController {
    private final BorrowingService borrowingService;

    /**
     * 책 대여
     * @param request CreateBorrowingRequest
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<CreateBorrowingResponse> createBorrowing(@RequestBody CreateBorrowingRequest request) {
        CreateBorrowingResponse createBorrowingResponse = borrowingService.createBorrowing(request);
        return ResponseEntity.created(URI.create("/books")).body(createBorrowingResponse);
    }

    /**
     * 책 반납
     * @param request UpdateBorrowingRequest
     * @return ResponseEntity
     */
    @PatchMapping
    public ResponseEntity<UpdateBorrowingResponse> updateBorrowing(@RequestBody UpdateBorrowingRequest request) {
        UpdateBorrowingResponse updateBorrowingResponse = borrowingService.updateBorrowing(request);
        return ResponseEntity.ok().body(updateBorrowingResponse);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ReadBorrowingResponse> readBorrowingList(@PathVariable("bookId") Long bookId) {
        ReadBorrowingResponse readBorrowingResponse = borrowingService.readBorrowingList(bookId);
        return ResponseEntity.ok().body(readBorrowingResponse);
    }
}
