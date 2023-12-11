package com.example.librarymanagement.borrowing.controller;

import com.example.librarymanagement.borrowing.dto.CreateBorrowingRequest;
import com.example.librarymanagement.borrowing.dto.CreateBorrowingResponse;
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

    @PostMapping("/{bookId}")
    public ResponseEntity<CreateBorrowingResponse> createBooks(@RequestBody CreateBorrowingRequest request) {
        CreateBorrowingResponse createBorrowingResponse = borrowingService.createBorrowing(request);
        return ResponseEntity.created(URI.create("/books")).body(createBorrowingResponse);
    }
}
