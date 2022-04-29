package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.post.request.PostRequest;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;

import java.util.List;

public interface PostService extends BaseService<PostResponse, PostRequest>{
    List<PostResponse> getPostByUserId(Long id);
}
