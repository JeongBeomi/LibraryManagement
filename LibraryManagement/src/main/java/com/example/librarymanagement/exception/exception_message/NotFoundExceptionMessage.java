package com.example.librarymanagement.exception.exception_message;

public class NotFoundExceptionMessage extends RuntimeException{

  public static final String NOT_FOUND_BOOKS = "존재하지 않는 책입니다.";
  public static final String NOT_FOUND_USER = "존재하지 않는 유저입니다.";
  public static final String NOT_FOUND_BORROWING = "존재하지 않는 대여기록입니다.";

  public NotFoundExceptionMessage(String message) {
    super(message);
  }
}