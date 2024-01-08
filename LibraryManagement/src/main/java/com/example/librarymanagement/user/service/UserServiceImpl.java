package com.example.librarymanagement.user.service;

import com.example.librarymanagement.exception.exception_message.ConflictExceptionMessage;
import com.example.librarymanagement.exception.exception_message.NotFoundExceptionMessage;
import com.example.librarymanagement.user.dto.CreateUserRequest;
import com.example.librarymanagement.user.dto.CreateUserResponse;
import com.example.librarymanagement.user.entity.User;
import com.example.librarymanagement.user.repository.UserRepository;
import com.example.librarymanagement.util.Encrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) {
        Optional<User> findUser = userRepository.findByEmail(request.getEmail());
        // 이미 존재하는 이메일을 사용할 경우 에러 발생
        if (findUser.isPresent()) {
            throw new ConflictExceptionMessage(ConflictExceptionMessage.EXIST_USER);
        }
        // 회원가입 가능 할 때
        else {
            String salt = Encrypt.getSalt();
            String encrypt = Encrypt.getEncrypt(request.getPassword(), salt);
            User user = User.create(request.getName(), request.getEmail(), salt, encrypt);
            User saveUser = userRepository.save(user);
            return CreateUserResponse.builder()
                    .userId(saveUser.getId())
                    .name(saveUser.getName())
                    .email(saveUser.getEmail())
                    .build();
        }
    }
}
