package com.example.librarymanagement.borrowing.service;

import com.example.librarymanagement.books.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {
    private final BooksRepository booksRepository;


}
