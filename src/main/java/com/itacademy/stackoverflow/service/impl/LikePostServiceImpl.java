package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.like.request.LikePostRequest;
import com.itacademy.stackoverflow.dto.like.response.LikePostResponse;
import com.itacademy.stackoverflow.entity.LikePostEntity;
import com.itacademy.stackoverflow.repository.LikePostRepository;
import com.itacademy.stackoverflow.repository.PostRepository;
import com.itacademy.stackoverflow.repository.UserRepository;
import com.itacademy.stackoverflow.service.LikePostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LikePostServiceImpl implements LikePostService {

    final UserRepository userRepository;

    final PostRepository postRepository;

    final LikePostRepository likePostRepository;

    @Override
    public LikePostResponse addLike(LikePostRequest likePostRequest) {
        likePostRepository
                .save(LikePostEntity.builder()
                        .postEntity(postRepository.getById(likePostRequest.getPostId()))
                        .userEntity(userRepository.getById(likePostRequest.getUserId())).build());
        return LikePostResponse.builder().post_id(likePostRequest.getPostId())
                .count_like(likePostRequest.getPostId()).build();
    }

    @Override
    public LikePostResponse deleteLike(LikePostRequest likePostRequest) {
        likePostRepository.delete(likePostRepository.getByPostEntityId(likePostRequest.getPostId()));
        return LikePostResponse.builder().post_id(likePostRequest.getPostId())
                .count_like(likePostRequest.getPostId()).build();
    }
}
