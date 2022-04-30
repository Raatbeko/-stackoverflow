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
import com.itacademy.stackoverflow.service.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    final
    PostRepository postRepository;

    final DiscussionPostService service;

    final FilePostService filePostService;

    final
    CommentService commentService;

    final
    UserService userService;

    final
    LikePostRepository likePostRepository;


    @Override
    public PostResponse save(PostRequest postRequest) {

        PostEntity postEntity = postRepository
                .save(PostEntity.builder()
                        .userEntity(UserMapper.INSTANCE.toUserEntity(userService.findById(postRequest.getUserId())))
                        .header(postRequest.getHeader())
                        .build());
        List<DiscussionRequest> discussionEntities = postRequest.getDiscussionRequests();

        service.save(postRequest.getDiscussionRequests(), postEntity);

        filePostService.save(postRequest.getFileRequests(), postEntity);

        return PostResponse.builder()
                .id(postEntity.getId())
                .discussion(DiscussionMapper.INSTANCE.toDiscussionResponse(discussionEntities))
                .header(postEntity.getHeader())
                .file(FileMapper.INSTANCE.toFileResponse(postRequest.getFileRequests()))
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
    public PostResponse delete(Long id) {
        return null;
    }

    @Override
    public List<PostResponse> getPostByUserId(Long id) {
        List<PostEntity> postEntities = postRepository.findByUserEntityId(id);
        List<PostResponse> postResponses = new ArrayList<>();

        for (PostEntity postEntity : postEntities) {
            postResponses.
                    add(PostResponse.builder()
                            .id(postEntity.getId())
                            .header(postEntity.getHeader())
                            .userId(postEntity.getId()).build());
        }

        for (PostResponse postResponse : postResponses) {
            Long id1 = postResponse.getId();
            postResponse.setCountLike(likePostRepository.countLikePostEntityById(id1));
            postResponse.setCommentResponses(commentService.getByPostId(id1));
            postResponse.setDiscussion(service.getByPostId(id1));
            postResponse.setFile(filePostService.getByPostId(id1));
        }

        return postResponses;
    }
}
