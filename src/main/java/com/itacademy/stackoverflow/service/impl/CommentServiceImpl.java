package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
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

    @Override
    public CommentResponse save(CommentRequest commentRequest) {
        CommentEntity commentEntity = repository.save(CommentMapper.INSTANCE.toCommentRequest(commentRequest));

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
        return CommentMapper.INSTANCE.toCommentResponse(commentRequest);
    }

    @Override
    public List<CommentResponse> getAll() {
        return CommentMapper.INSTANCE.toCommentResponse(repository.findAll());
    }

    @Override
    public CommentResponse findById(Long id) {


        return null;
    }
}
