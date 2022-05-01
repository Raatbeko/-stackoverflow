package com.itacademy.stackoverflow.mapper;

import antlr.build.ANTLR;
import com.itacademy.stackoverflow.dto.user.request.UserAuthRequest;
import com.itacademy.stackoverflow.dto.user.request.UserRequest;
import com.itacademy.stackoverflow.dto.user.response.UserResponse;
import com.itacademy.stackoverflow.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    

    UserResponse toUserResponseDto(UserEntity user);

    List<UserResponse> toUsersResponseDto(List<UserEntity> users);

    UserAuthRequest toUserAuthDto(UserEntity user);

    UserEntity toUserEntity(UserResponse userResponse);

    default void test(UserRequest userRequest){

    }
}