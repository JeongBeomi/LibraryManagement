package com.example.librarymanagement.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.time.LocalDateTime;

@Getter
@Builder
public class ExceptionResponse {
  private final LocalDateTime timestamp;
  private final String path;
  private final HttpStatus httpStatus;
  private final String message;

  public static ExceptionResponse createExceptionResponse(Exception e, HttpStatus httpStatus, HttpServletRequest request){
    final String message = e.getMessage();
    final String path = request.getRequestURI();
    return ExceptionResponse.builder()
        .timestamp(LocalDateTime.now())
        .path(path)
        .httpStatus(httpStatus)
        .message(message)
        .build();
  }
}

