package com.example.librarymanagement.user.service;

import com.example.librarymanagement.user.dto.CreateUserRequest;
import com.example.librarymanagement.user.dto.CreateUserResponse;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest request);
}
