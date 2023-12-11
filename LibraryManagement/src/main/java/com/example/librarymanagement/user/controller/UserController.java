package com.example.librarymanagement.user.controller;

import com.example.librarymanagement.user.dto.CreateUserRequest;
import com.example.librarymanagement.user.dto.CreateUserResponse;
import com.example.librarymanagement.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        CreateUserResponse createUserResponse = userService.createUser(createUserRequest);
        return ResponseEntity.created(URI.create("/user")).body(createUserResponse);
    }
}
