package com.example.librarymanagement.user.entity;

import com.example.librarymanagement.util.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="user")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String salt;


    //==비즈니스 로직==//

    //생성 메서드
    public static User create(String name, String email, String salt, String encrypt) {
        return User.builder()
                .name(name)
                .email(email)
                .password(encrypt)
                .salt(salt)
                .build();
    }

}
