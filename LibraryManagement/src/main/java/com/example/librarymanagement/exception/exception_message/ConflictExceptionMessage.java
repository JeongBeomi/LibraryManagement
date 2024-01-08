package com.example.librarymanagement.exception.exception_message;

public class ConflictExceptionMessage extends RuntimeException{
    public static final String EXIST_USER = "이미 존재하는 유저입니다.";
    public static final String EXIST_BORROWING = "이미 대여중인 책입니다.";

    public ConflictExceptionMessage(String message) {
        super(message);
    }
}
