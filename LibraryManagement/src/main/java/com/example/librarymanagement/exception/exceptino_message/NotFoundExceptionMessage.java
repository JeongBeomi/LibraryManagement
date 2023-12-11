package com.example.librarymanagement.exception.exceptino_message;

/**
 * packageName    : com.project.fri.exception.exceptino_message fileName       :
 * NotFoundExceptionMessage date           : 2023-04-19 description    :
 */
public class NotFoundExceptionMessage extends RuntimeException{

  public static final String EXIST_USER = "이미 존재하는 유저입니다.";
  public static final String EXIST_BORROWING = "이미 대여중인 책입니다.";
  public static final String NOT_FOUND_BOOKS = "존재하지 않는 책입니다.";
  public static final String NOT_FOUND_USER = "존재하지 않는 유저입니다.";

  public static final String NOT_FOUND_ROOM_LIST = "존재하지 않는 방 리스트 입니다.";



  public NotFoundExceptionMessage() {
    super();
  }

  public NotFoundExceptionMessage(String message) {
    super(message);
  }
}