package com.example.librarymanagement.borrowing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ReadBorrowingResponse {
    List<ReadBorrowingInstance> borrowingHistory;
}
