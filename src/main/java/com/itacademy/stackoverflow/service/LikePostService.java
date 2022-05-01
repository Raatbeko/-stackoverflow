package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.like.request.LikePostRequest;
import com.itacademy.stackoverflow.dto.like.response.LikePostResponse;

public interface LikePostService {
    LikePostResponse addLike(LikePostRequest likePostRequest);

    LikePostResponse deleteLike(LikePostRequest likeCommentRequest);
}
