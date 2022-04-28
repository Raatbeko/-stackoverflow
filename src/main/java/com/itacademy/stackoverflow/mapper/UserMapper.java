package com.itacademy.stackoverflow.mapper;

import com.itacademy.stackoverflow.dto.user.request.UserAuthRequest;
import com.itacademy.stackoverflow.dto.user.request.UserRequest;
import com.itacademy.stackoverflow.dto.user.response.UserResponse;
import com.itacademy.stackoverflow.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toUserEntity(UserRequest userRequestDto);

    UserResponse toUserResponseDto(UserEntity user);

    List<UserResponse> toUsersResponseDto(List<UserEntity> users);

    UserAuthRequest toUserAuthDto(UserEntity user);
}