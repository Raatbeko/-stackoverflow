package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.*;
import com.itacademy.stackoverflow.mapper.DiscussionMapper;
import com.itacademy.stackoverflow.repository.*;
import com.itacademy.stackoverflow.service.CommentService;
import com.itacademy.stackoverflow.service.FileCommentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    final
    CommentRepository commentRepository;

    final
    DiscussionCommentServiceImpl discussionCommentService;

    final FileCommentService fileCommentService;

    final
    LikeCommentRepository likeCommentRepository;

    final
    UserRepository userRepository;

    final
    PostRepository postRepository;



    @Override
    public CommentResponse save(CommentRequest commentRequest) {
        CommentEntity commentEntity = commentRepository
                .save(CommentEntity.builder()
                        .post(postRepository.getById(commentRequest.getPostId()))
                        .user(userRepository.getById(commentRequest.getUserId())).build());
        discussionCommentService.save(commentRequest.getDiscussionRequests(),commentEntity);

        List<FileResponse> fileResponses = fileCommentService.save(commentRequest.getMultipartFiles(),commentEntity);

        return CommentResponse.builder()
                .postId(commentRequest.getPostId())
                .userId(commentRequest.getUserId())
                .discussion(DiscussionMapper.INSTANCE.toDiscussionResponse(commentRequest.getDiscussionRequests()))
                .multipartFiles(fileResponses)
                .id(commentEntity.getId()).build();
    }

    @Override
    public List<CommentResponse> getAll() {
        return null;
    }

    @Override
    public List<CommentResponse> getByPostId(Long id) {
        List<CommentEntity> commentEntities = commentRepository.findByPostId(id);
        List<CommentResponse> commentResponse = new ArrayList<>();
        for (CommentEntity commentEntity : commentEntities) {
            commentResponse
                    .add(CommentResponse.builder()
                            .id(commentEntity.getId())
                            .userId(commentEntity.getUser().getId())
                            .postId(commentEntity.getPost().getId())
                            .build());
        }

        for (int i = 0; i < commentResponse.size(); i++) {
            commentResponse.get(i)
                    .setCountLike(likeCommentRepository
                            .countLikeCommentEntityById(commentResponse.get(i).getId()));

            List<DiscussionResponse> discussionResponses = discussionCommentService.getByCommentId(commentResponse.get(i).getId());

            commentResponse.get(i).setDiscussion(discussionResponses);

            commentResponse.get(i).setMultipartFiles(fileCommentService.getByCommentId(commentResponse.get(i).getId()));

        }
        return commentResponse;
    }


    @Override
    public CommentResponse findById(Long id) {
        CommentEntity commentEntity = commentRepository.getById(id);
        return CommentResponse.builder().build();
    }

    @Override
    public CommentResponse delete(Long id) {
        CommentEntity commentEntity = commentRepository.getById(id);
        discussionCommentService.deleteAllDiscussionByCommentId(commentEntity.getId());
        fileCommentService.deleteAllFileByCommentId(commentEntity.getId());
        commentRepository.delete(commentEntity);
        return CommentResponse.builder().build();
    }

    @Override
    public Boolean deleteAllCommentsByPostId(Long id) {
        List<CommentEntity> commentEntities = commentRepository.findAllCommentsByPostId(id);
        for (CommentEntity commentEntity: commentEntities){
            commentRepository.delete(commentEntity);
        }
        return true;
    }

    @Override
    public List<CommentResponse> getByUserId(Long id) {

        List<CommentEntity> commentEntities = commentRepository.findByUserId(id);
        List<CommentResponse> commentResponse = new ArrayList<>();

        for (CommentEntity commentEntity : commentEntities) {
            commentResponse
                    .add(CommentResponse.builder()
                            .id(commentEntity.getId())
                            .userId(commentEntity.getUser().getId())
                            .postId(commentEntity.getPost().getId())
                            .build());
        }

        for (int i = 0; i < commentResponse.size(); i++) {
            commentResponse.get(i)
                    .setCountLike(likeCommentRepository
                            .countLikeCommentEntityById(commentResponse.get(i).getId()));

            List<DiscussionResponse> discussionResponses = discussionCommentService.getByCommentId(commentResponse.get(i).getId());

            commentResponse.get(i).setDiscussion(discussionResponses);

            commentResponse.get(i).setMultipartFiles(fileCommentService.getByCommentId(commentResponse.get(i).getId()));

        }

        return commentResponse;
    }


}
