package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.user.request.UserAuthRequest;
import com.itacademy.stackoverflow.dto.user.request.UserRequest;
import com.itacademy.stackoverflow.dto.user.response.UserResponse;
import com.itacademy.stackoverflow.entity.UserEntity;
import com.itacademy.stackoverflow.exception.EmailNotBeEmptyException;
import com.itacademy.stackoverflow.exception.UserSignInException;
import com.itacademy.stackoverflow.mapper.UserMapper;
import com.itacademy.stackoverflow.repository.RoleRepository;
import com.itacademy.stackoverflow.repository.UserRepository;
import com.itacademy.stackoverflow.repository.UserRoleRepository;
import com.itacademy.stackoverflow.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserResponse save(UserRequest t) {
        if (t.getEmail() == null) throw new EmailNotBeEmptyException("email is empty", HttpStatus.valueOf("EMAIL_NOT_BE_EMPTY"));
        UserEntity userEntity = userRepository
                .save(UserEntity.builder()
                        .login(t.getLogin())
                        .email(t.getEmail())
                        .password(passwordEncoder.encode(t.getPassword()))
                        .isActive(true)
                        .build());


        return UserResponse.builder()
                .email(userEntity.getEmail())
                .id(userEntity.getId())
                .login(userEntity.getLogin())
                .build();
    }

    @Override
    public String getToken(UserAuthRequest request) throws UserSignInException {
        UserEntity userEntity = userRepository.findByUserNameAndEMail(request.getLoginOrEmail());
        boolean isMatches = passwordEncoder.matches(request.getPassword(), userEntity.getPassword());
        if (isMatches){
            return  "Basic " + new String(Base64.getEncoder()
                    .encode((userEntity.getLogin() + ":" + request.getPassword()).getBytes()));
        }else {
            throw new UserSignInException("Неправильный логин или пароль!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<UserResponse> getAll() {
        return UserMapper.INSTANCE.toUsersResponseDto(userRepository.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        return UserMapper.INSTANCE.toUserResponseDto(userRepository.getById(id));
    }

    @Override
    public UserResponse delete(Long id) {
        return null;
    }

}
