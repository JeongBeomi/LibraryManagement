package com.example.librarymanagement.borrowing.service;

import com.example.librarymanagement.books.entity.Books;
import com.example.librarymanagement.books.repository.BooksRepository;
import com.example.librarymanagement.borrowing.dto.*;
import com.example.librarymanagement.borrowing.entity.Borrowing;
import com.example.librarymanagement.borrowing.repository.BorrowingRepository;
import com.example.librarymanagement.exception.exception_message.ConflictExceptionMessage;
import com.example.librarymanagement.exception.exception_message.NotFoundExceptionMessage;
import com.example.librarymanagement.user.entity.User;
import com.example.librarymanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
            throw new ConflictExceptionMessage(ConflictExceptionMessage.EXIST_BORROWING);
        }

        Borrowing borrowing = Borrowing.create(findUser, findBooks);
        Borrowing saveBorrowing = borrowingRepository.save(borrowing);
        Books books = findBooks.updateIsBorrowing();


        return CreateBorrowingResponse.create(books, findUser, saveBorrowing);
    }

    @Override
    @Transactional
    public UpdateBorrowingResponse updateBorrowing(UpdateBorrowingRequest request) {
        Borrowing findBorrowing = borrowingRepository.findByBooksAndUpdatedAtNullWithBooks(request.getBooksId())
                .orElseThrow(() -> new NotFoundExceptionMessage(NotFoundExceptionMessage.NOT_FOUND_BORROWING));

        findBorrowing.updateReturnDate();
        Books books = findBorrowing.getBooks().updateIsBorrowing();

        return UpdateBorrowingResponse.create(books, findBorrowing);
    }

    @Override
    @Transactional
    public ReadBorrowingResponse readBorrowingList(Long booksId) {
        List<Borrowing> borrowingsList = borrowingRepository.findByBooksIdWithUser(booksId);

        List<ReadBorrowingInstance> borrowingHistory = new ArrayList<>();
        for (Borrowing b : borrowingsList) {
            borrowingHistory.add(ReadBorrowingInstance.create(b.getUser().getEmail(), b));
        }

        return new ReadBorrowingResponse(borrowingHistory);

    }
}
