package com.example.librarymanagement.books.service;

import com.example.librarymanagement.books.dto.CreateBooksRequest;
import com.example.librarymanagement.books.dto.CreateBooksResponse;
import com.example.librarymanagement.books.entity.Books;
import com.example.librarymanagement.books.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;

    @Override
    @Transactional
    public CreateBooksResponse createBooks(CreateBooksRequest request) {
        Books books = Books.create(request.getTitle(), request.getAuthor(), request.getIsbn());
        Books saveBooks = booksRepository.save(books);
        return CreateBooksResponse.create(saveBooks);
    }


}
