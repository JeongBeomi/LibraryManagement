package com.example.librarymanagement.books.controller;

import com.example.librarymanagement.books.dto.CreateBooksRequest;
import com.example.librarymanagement.books.dto.CreateBooksResponse;
import com.example.librarymanagement.books.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    /**
     * 책 등록 *
     * @param request CreateBooksRequest
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<CreateBooksResponse> createBooks(@RequestBody CreateBooksRequest request) {
        CreateBooksResponse createBooksResponse = booksService.createBooks(request);
        return ResponseEntity.created(URI.create("/books")).body(createBooksResponse);
    }


}