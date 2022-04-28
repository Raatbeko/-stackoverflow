package com.itacademy.stackoverflow.mapper;

import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.entity.PostEntity;
import com.itacademy.stackoverflow.service.PostService;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostResponse toPostResponseDto(PostEntity postEntity);

    List<PostResponse> toPostResponse(List<PostEntity> postEntities);

}
