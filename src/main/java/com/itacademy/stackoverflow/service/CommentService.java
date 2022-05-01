package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.entity.CommentEntity;

import java.util.List;

public interface CommentService extends BaseService<CommentResponse, CommentRequest> {
    List<CommentResponse> getByPostId(Long id);
    Boolean deleteAllCommentsByPostId(Long id);
    List<CommentResponse> getByUserId(Long id);
}
