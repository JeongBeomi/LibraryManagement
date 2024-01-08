package com.example.librarymanagement.exception;

import com.example.librarymanagement.exception.exception_message.ConflictExceptionMessage;
import com.example.librarymanagement.exception.exception_message.NotFoundExceptionMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * packageName    : com.project.fri.exception fileName       : ControllerAdvisor date           :
 * 2023-04-19 description    :
 */
@RestControllerAdvice
@Slf4j
public class ControllerAdvisor {
  @ExceptionHandler(NotFoundExceptionMessage.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionResponse notFoundExceptionHandler(NotFoundExceptionMessage e, HttpServletRequest request){
    return ExceptionResponse.createExceptionResponse(e, HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler(ConflictExceptionMessage.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ExceptionResponse conflictExceptionMessage(ConflictExceptionMessage e, HttpServletRequest request){
    return ExceptionResponse.createExceptionResponse(e, HttpStatus.CONFLICT, request);
  }
}
