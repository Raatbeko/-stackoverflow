package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.dto.post.request.PostRequest;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.entity.DiscussionEntity;
import com.itacademy.stackoverflow.entity.DiscussionPostEntity;
import com.itacademy.stackoverflow.entity.FilePostEntity;
import com.itacademy.stackoverflow.entity.PostEntity;
import com.itacademy.stackoverflow.mapper.DiscussionMapper;
import com.itacademy.stackoverflow.mapper.FileMapper;
import com.itacademy.stackoverflow.mapper.UserMapper;
import com.itacademy.stackoverflow.repository.*;
import com.itacademy.stackoverflow.service.CommentService;
import com.itacademy.stackoverflow.service.FileService;
import com.itacademy.stackoverflow.service.PostService;
import com.itacademy.stackoverflow.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    FilePostRepository filePostRepository;

    @Autowired
    DiscussionPostRepository discussionPostRepository;

    @Autowired
    FileService fileService;

    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Override
    public PostResponse save(PostRequest postRequest) {

        PostEntity postEntity = postRepository
                .save(PostEntity.builder()
                        .userEntity(UserMapper.INSTANCE.toUserEntity(userService.findById(postRequest.getUserId())))
                        .header(postRequest.getHeader())
                        .build());
        List<DiscussionRequest> discussionEntities = postRequest.getDiscussionRequests();
        for (DiscussionRequest discussion : discussionEntities) {
            DiscussionEntity discussionEntity1 = discussionRepository.save(DiscussionMapper.INSTANCE.toDiscussionRequest(discussion));
            discussionPostRepository
                    .save(DiscussionPostEntity.builder()
                            .discussionEntity(discussionEntity1)
                            .postEntity(postEntity).build());
        }
        List<FileRequest> fileRequests = postRequest.getFileRequests();
        for (FileRequest fileRequest : fileRequests) {
            FileResponse fileResponse = fileService.save(fileRequest);
            filePostRepository
                    .save(FilePostEntity.builder()
                            .fileEntity(FileMapper.INSTANCE.toFileResponse(fileResponse))
                            .postEntity(postEntity).build());
        }
        return PostResponse.builder()
                .discussion(DiscussionMapper.INSTANCE.toDiscussionResponse(discussionEntities))
                .header(postEntity.getHeader())
                .file(FileMapper.INSTANCE.toFileResponse(fileRequests))
                .userId(postEntity.getUserEntity().getId())
                .build();
    }

    @Override
    public List<PostResponse> getAll() {
        return null;
    }

    @Override
    public PostResponse findById(Long id) {
        return null;
    }

    @Override
    public List<PostResponse> getPostByUserId(Long id) {

        return null;
    }
}
