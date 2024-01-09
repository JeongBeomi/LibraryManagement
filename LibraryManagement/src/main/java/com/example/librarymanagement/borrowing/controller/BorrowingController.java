package com.example.librarymanagement.borrowing.controller;

import com.example.librarymanagement.borrowing.dto.*;
import com.example.librarymanagement.borrowing.service.BorrowingService;
import jakarta.validation.Valid;
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
     * @param createBorrowingRequest 대여자 정보
     * @return 대여 성공시 응답
     */
    @PostMapping
    public ResponseEntity<CreateBorrowingResponse> createBorrowing(@RequestBody @Valid CreateBorrowingRequest createBorrowingRequest) {
        CreateBorrowingResponse createBorrowingResponse = borrowingService.createBorrowing(createBorrowingRequest);
        return ResponseEntity.created(URI.create("/books/" + createBorrowingResponse.getBorrowingId())).body(createBorrowingResponse);
    }

    /**
     * 책 반납
     * @param request UpdateBorrowingRequest
     * @return ResponseEntity
     */
    @PatchMapping
    public ResponseEntity<UpdateBorrowingResponse> updateBorrowing(@RequestBody @Valid UpdateBorrowingRequest request) {
        UpdateBorrowingResponse updateBorrowingResponse = borrowingService.updateBorrowing(request);
        return ResponseEntity.ok().body(updateBorrowingResponse);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ReadBorrowingResponse> readBorrowingList(@PathVariable("bookId") Long bookId) {
        ReadBorrowingResponse readBorrowingResponse = borrowingService.readBorrowingList(bookId);
        return ResponseEntity.ok().body(readBorrowingResponse);
    }
}
