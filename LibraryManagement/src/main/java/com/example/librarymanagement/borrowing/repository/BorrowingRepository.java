package com.example.librarymanagement.borrowing.repository;

import com.example.librarymanagement.borrowing.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    @Query("SELECT r FROM Borrowing r JOIN FETCH r.books WHERE r.books.id = :booksId AND r.updatedAt IS NULL")
    Optional<Borrowing> findByBooksAndUpdatedAtNullWithBooks(@Param("booksId") Long booksId);
}
