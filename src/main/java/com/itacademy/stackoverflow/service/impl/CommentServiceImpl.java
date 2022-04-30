package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.*;
import com.itacademy.stackoverflow.mapper.CommentMapper;
import com.itacademy.stackoverflow.mapper.DiscussionMapper;
import com.itacademy.stackoverflow.mapper.FileMapper;
import com.itacademy.stackoverflow.repository.*;
import com.itacademy.stackoverflow.service.CommentService;
import com.itacademy.stackoverflow.service.FileService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository repository;

    @Autowired
    DiscussionCommentRepository discussionCommentRepository;

    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    FileService fileService;

    @Autowired
    FileCommentRepository fileCommentRepository;

    @Autowired
    LikeCommentRepository likeCommentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    @Override
    public CommentResponse save(CommentRequest commentRequest) {
        CommentEntity commentEntity = repository
                .save(CommentEntity.builder()
                        .post(postRepository.getById(commentRequest.getPostId()))
                        .user(userRepository.getById(commentRequest.getUserId())).build());

        for (DiscussionRequest discussionRequest : commentRequest.getDiscussionRequests()) {
            DiscussionEntity discussionEntity = discussionRepository.save(DiscussionMapper.INSTANCE.toDiscussionRequest(discussionRequest));
            discussionCommentRepository
                    .save(DiscussionCommentEntity.builder()
                            .commentEntity(commentEntity)
                            .discussionEntity(discussionEntity)
                            .build());
        }

        for (FileRequest multipartFile : commentRequest.getMultipartFiles()) {
            FileResponse fileResponse = fileService.save(multipartFile);

            fileCommentRepository
                    .save(FileCommentEntity.builder()
                            .commentEntity(commentEntity)
                            .fileEntity(FileMapper.INSTANCE.toFileResponse(fileResponse))
                            .build());
        }

        commentRequest.setCountLike(likeCommentRepository.countLikeCommentEntityById(commentEntity.getId()));

        return CommentMapper.INSTANCE.toCommentResponse(commentRequest);
    }

    @Override
    public List<CommentResponse> getAll() {
        return null;
    }

    @Override
    public List<CommentResponse> getByPostId(Long id) {
        List<CommentEntity> commentEntities = repository.findByPostId(id);
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

            List<DiscussionCommentEntity> discussionCommentEntities = discussionCommentRepository.findAll();
            List<DiscussionResponse> discussionResponses = new ArrayList<>();

            for (int i1 = 0; i1 < discussionCommentEntities.size(); i1++) {
                DiscussionResponse discussion =
                        DiscussionMapper.INSTANCE.toDiscussionResponse(
                                discussionRepository.getById(discussionCommentRepository.getByCommentEntityId(CommentMapper.INSTANCE.toCommentRequest(commentResponse).getId())));
                discussionResponses.add(discussion);
            }
            commentResponse.get(i).setDiscussion(discussionResponses);

            List<FileCommentEntity> fileCommentEntities = fileCommentRepository.findAll();
            List<FileResponse> fileResponses = new ArrayList<>();

            for (int i1 = 0; i1 < fileCommentEntities.size(); i1++) {
                FileResponse fileResponse =
                        fileService.findById(fileCommentRepository.getByCommentEntityId(CommentMapper.INSTANCE.toCommentRequest(commentResponse).getId()));
                fileResponses.add(fileResponse);
            }
            commentResponse.get(i).setMultipartFiles(fileResponses);

        }
        return commentResponse;
    }


    @Override
    public CommentResponse findById(Long id) {

        return null;
    }
}
