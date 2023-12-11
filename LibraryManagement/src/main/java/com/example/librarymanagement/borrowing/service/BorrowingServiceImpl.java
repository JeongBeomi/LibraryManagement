package com.example.librarymanagement.borrowing.service;

import com.example.librarymanagement.books.entity.Books;
import com.example.librarymanagement.books.repository.BooksRepository;
import com.example.librarymanagement.borrowing.dto.CreateBorrowingRequest;
import com.example.librarymanagement.borrowing.dto.CreateBorrowingResponse;
import com.example.librarymanagement.borrowing.entity.Borrowing;
import com.example.librarymanagement.borrowing.repository.BorrowingRepository;
import com.example.librarymanagement.exception.exceptino_message.NotFoundExceptionMessage;
import com.example.librarymanagement.user.entity.User;
import com.example.librarymanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {
    private final BooksRepository booksRepository;
    private final UserRepository userRepository;
    private final BorrowingRepository borrowingRepository;


    @Override
    @Transactional
    public CreateBorrowingResponse createBorrowing(CreateBorrowingRequest request) {
        User findUser = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new NotFoundExceptionMessage(NotFoundExceptionMessage.NOT_FOUND_USER)
        );

        Books findBooks = booksRepository.findById(request.getBooksId()).orElseThrow(
                () -> new NotFoundExceptionMessage((NotFoundExceptionMessage.NOT_FOUND_BOOKS))
        );

        // 이미 대여되어 대여가 불가능한 상태
        if (findBooks.isBorrowing()) {
            throw new NotFoundExceptionMessage(NotFoundExceptionMessage.EXIST_BORROWING);
        }

        Borrowing borrowing = Borrowing.create(findUser, findBooks);
        Borrowing saveBorrowing = borrowingRepository.save(borrowing);
        Books books = findBooks.update();


        return CreateBorrowingResponse.create(books, findUser, saveBorrowing);
    }
}
