package com.example.librarymanagement.user.controller;

import com.example.librarymanagement.user.dto.CreateUserRequest;
import com.example.librarymanagement.user.dto.CreateUserResponse;
import com.example.librarymanagement.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    /**
     * 회원 가입
     * @param createUserRequest 회원가입시 필요한 정보
     * @return 회원 가입 성공시 응답
     */
    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        CreateUserResponse createUserResponse = userService.createUser(createUserRequest);
        return ResponseEntity.created(URI.create("/user/" + createUserResponse.getUserId())).body(createUserResponse);
    }
}
