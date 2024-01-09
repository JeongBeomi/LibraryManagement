package com.example.librarymanagement.books.service;

import com.example.librarymanagement.books.dto.CreateBooksRequest;
import com.example.librarymanagement.books.dto.CreateBooksResponse;
import com.example.librarymanagement.books.dto.UpdateBooksRequest;
import com.example.librarymanagement.books.dto.UpdateBooksResponse;
import com.example.librarymanagement.books.entity.Books;
import com.example.librarymanagement.books.repository.BooksRepository;
import com.example.librarymanagement.exception.exception_message.NotFoundExceptionMessage;
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

    @Override
    @Transactional
    public UpdateBooksResponse updateBooks(UpdateBooksRequest request, Long booksId) {
        Books findBooks = booksRepository.findById(booksId).orElseThrow(
                () -> new NotFoundExceptionMessage(NotFoundExceptionMessage.NOT_FOUND_BOOKS)
        );
        Books updateBooks = findBooks.updateBooks(request);

        return UpdateBooksResponse.create(updateBooks);
    }

}
