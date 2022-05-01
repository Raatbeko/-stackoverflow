package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.like.request.LikeCommentRequest;
import com.itacademy.stackoverflow.dto.like.response.LikeCommentResponse;
import com.itacademy.stackoverflow.entity.LikeCommentEntity;
import com.itacademy.stackoverflow.repository.CommentRepository;
import com.itacademy.stackoverflow.repository.LikeCommentRepository;
import com.itacademy.stackoverflow.repository.UserRepository;
import com.itacademy.stackoverflow.service.LikeCommentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LikeCommentServiceImpl implements LikeCommentService {

    final LikeCommentRepository commentRepository;

    final CommentRepository comment;

    final UserRepository userRepository;

    @Override
    public LikeCommentResponse addLike(LikeCommentRequest likeCommentRequest) {
        LikeCommentEntity commentEntity = commentRepository
                .save(LikeCommentEntity.builder()
                        .commentEntity(comment.getById(likeCommentRequest.getCommentId()))
                        .userEntity(userRepository.getById(likeCommentRequest.getUserId())).build());
        return LikeCommentResponse.builder()
                .comment_id(likeCommentRequest.getCommentId())
                .count_like(commentRepository.countLikeCommentEntityById(likeCommentRequest.getCommentId())).build();
    }

    @Override
    public LikeCommentResponse deleteLike(LikeCommentRequest likeCommentRequest) {
        commentRepository
                .delete(commentRepository.getByCommentEntityId(likeCommentRequest.getUserId()));
        return LikeCommentResponse.builder()
                .comment_id(likeCommentRequest.getCommentId())
                .count_like(commentRepository.countLikeCommentEntityById(likeCommentRequest.getUserId())).build();
    }
}
