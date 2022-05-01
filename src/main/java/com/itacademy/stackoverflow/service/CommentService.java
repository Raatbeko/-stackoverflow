package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;

import java.util.List;

public interface CommentService extends BaseService<CommentResponse, CommentRequest> {
    List<CommentResponse> getByPostId(Long id);

    List<CommentResponse> getAllByUserId(Long id);
}
