package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.user.request.UserAuthRequest;
import com.itacademy.stackoverflow.dto.user.request.UserRequest;
import com.itacademy.stackoverflow.dto.user.response.UserResponse;
import com.itacademy.stackoverflow.exception.UserSignInException;

public interface UserService extends BaseService<UserResponse, UserRequest>{

    String getToken(UserAuthRequest request) throws UserSignInException;
}
