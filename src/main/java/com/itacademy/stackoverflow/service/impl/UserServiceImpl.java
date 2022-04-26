package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.user.request.UserRequest;
import com.itacademy.stackoverflow.dto.user.response.UserResponse;
import com.itacademy.stackoverflow.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    @Override
    public UserResponse save(UserRequest t) {
        return null;
    }

    @Override
    public List<UserResponse> getAll() {
        return null;
    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }
}
