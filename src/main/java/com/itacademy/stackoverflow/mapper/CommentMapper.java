package com.itacademy.stackoverflow.mapper;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.entity.CommentEntity;
import com.itacademy.stackoverflow.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
@FieldDefaults(level = AccessLevel.PRIVATE)
public interface CommentMapper {



     CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

     CommentEntity toCommentRequest(CommentRequest response);

     CommentResponse toCommentResponse(CommentEntity commentEntity);

     List<CommentResponse> toCommentResponse(List<CommentEntity> entities);

     CommentResponse toCommentResponse(CommentRequest commentRequest);

     CommentEntity toCommentRequest(CommentResponse commentResponse);
}
