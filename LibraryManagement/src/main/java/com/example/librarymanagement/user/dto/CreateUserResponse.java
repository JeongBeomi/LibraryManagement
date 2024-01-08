package com.example.librarymanagement.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateUserResponse {
    private Long userId;
    private String name;
    private String email;

}
