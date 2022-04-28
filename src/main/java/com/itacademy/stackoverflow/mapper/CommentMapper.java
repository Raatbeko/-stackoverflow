package com.itacademy.stackoverflow.mapper;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentEntity toCommentRequest(CommentRequest response);

    CommentResponse toCommentResponse(CommentEntity commentEntity);

    List<CommentResponse> toCommentResponse(List<CommentEntity> entities);

    CommentResponse toCommentResponse(CommentRequest commentRequest);

}
