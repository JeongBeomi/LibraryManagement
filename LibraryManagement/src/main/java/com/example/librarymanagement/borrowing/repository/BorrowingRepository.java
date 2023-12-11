package com.example.librarymanagement.borrowing.repository;

import com.example.librarymanagement.borrowing.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
