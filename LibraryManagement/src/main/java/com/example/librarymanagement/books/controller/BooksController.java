package com.example.librarymanagement.books.controller;

import com.example.librarymanagement.books.dto.CreateBooksRequest;
import com.example.librarymanagement.books.dto.CreateBooksResponse;
import com.example.librarymanagement.books.dto.UpdateBooksRequest;
import com.example.librarymanagement.books.dto.UpdateBooksResponse;
import com.example.librarymanagement.books.service.BooksService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BooksController {
    private final BooksService booksService;

    /**
     * 책 등록 *
     * @param createBooksRequest 도서 등록시 필요한 정보
     * @return 도서등록 성공시 응답
     */
    @PostMapping
    public ResponseEntity<CreateBooksResponse> createBooks(@RequestBody @Valid CreateBooksRequest createBooksRequest) {
        CreateBooksResponse createBooksResponse = booksService.createBooks(createBooksRequest);
        return ResponseEntity.created(URI.create("/book/" + createBooksResponse.getId())).body(createBooksResponse);
    }

    /**
     * 책정보 수정 *
     * @param updateBooksRequest 도서 정보 수정
     * @param bookId 도서 id
     * @return 도서 정보 수정 성공시 응답
     */
    @PatchMapping("/{bookId}")
    public ResponseEntity<UpdateBooksResponse> updateBooks(@RequestBody UpdateBooksRequest updateBooksRequest,
                                                           @PathVariable("bookId") Long bookId) {
        UpdateBooksResponse updateBooksResponse = booksService.updateBooks(updateBooksRequest, bookId);
        return ResponseEntity.ok().body(updateBooksResponse);
    }


}
