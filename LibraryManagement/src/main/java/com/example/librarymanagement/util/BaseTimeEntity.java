package com.example.librarymanagement.util;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName    : com.project.fri.util fileName       : BaseTimeEntity date           : 2023-04-18
 * description    :
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor



@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass

public abstract class BaseTimeEntity {

  @CreatedDate
  @NotNull
  private LocalDateTime createdAt; //생성일자

  @LastModifiedDate
  @NotNull
  private LocalDateTime updatedAt; //수정일자

  public BaseTimeEntity update(LocalDateTime updatedAt){
    this.updatedAt=updatedAt;
    return this;
  }
}