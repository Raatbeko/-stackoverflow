package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.like.request.LikeCommentRequest;
import com.itacademy.stackoverflow.dto.like.response.LikeCommentResponse;

public interface LikeCommentService {
    LikeCommentResponse addLike(LikeCommentRequest likeCommentRequest);

    LikeCommentResponse deleteLike(LikeCommentRequest likeCommentRequest);
}
