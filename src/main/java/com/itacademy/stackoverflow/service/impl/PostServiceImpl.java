package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.post.request.PostRequest;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.entity.PostEntity;
import com.itacademy.stackoverflow.mapper.DiscussionMapper;
import com.itacademy.stackoverflow.mapper.FileMapper;
import com.itacademy.stackoverflow.repository.*;
import com.itacademy.stackoverflow.service.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    final
    PostRepository postRepository;

    final DiscussionPostService discussionPostService;

    final FilePostService filePostService;

    final
    CommentService commentService;

    final
    UserService userService;

    final
    LikePostRepository likePostRepository;

    final UserRepository userRepository;


    @Override
    public PostResponse save(PostRequest postRequest) {

        PostEntity postEntity = postRepository
                .save(PostEntity.builder()
                        .userEntity(userRepository.getById(postRequest.getUserId()))
                        .header(postRequest.getHeader())
                        .build());
        List<DiscussionRequest> discussionEntities = postRequest.getDiscussionRequests();

        discussionPostService.save(postRequest.getDiscussionRequests(), postEntity);

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
        List<PostEntity> postEntities = postRepository.findAll();
        List<PostResponse> postResponses = new ArrayList<>();
        for (PostEntity postEntity : postEntities) {
            postResponses.
                    add(PostResponse.builder()
                            .id(postEntity.getId())
                            .header(postEntity.getHeader())
                            .userId(postEntity.getId()).build());
        }
        for (PostResponse postResponse : postResponses) {
            postResponse.setCountLike(likePostRepository.countLikePostEntityById(postResponse.getId()));
            postResponse.setCommentResponses(commentService.getByPostId(postResponse.getId()));
            postResponse.setDiscussion(discussionPostService.getByPostId(postResponse.getId()));
            postResponse.setFile(filePostService.getByPostId(postResponse.getId()));
        }

        return postResponses.stream()
                .sorted(Comparator.comparing(PostResponse::getCountLike))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse findById(Long id) {
        PostEntity postEntity = postRepository.getById(id);
        return PostResponse.builder()
                .id(postEntity.getId())
                .userId(postEntity.getId())
                .header(postEntity.getHeader())
                .file(filePostService.getByPostId(postEntity.getId()))
                .discussion(discussionPostService.getByPostId(postEntity.getId()))
                .commentResponses(commentService.getByPostId(postEntity.getId())).build();
    }

    @Override
    public PostResponse delete(Long id) {
        PostEntity postEntity = postRepository.getById(id);
        discussionPostService.deleteAllDiscussionByPostId(postEntity.getId());
        filePostService.deleteAllFileByPostId(postEntity.getId());
        commentService.deleteAllCommentsByPostId(postEntity.getId());
        postRepository.delete(postEntity);
        return PostResponse.builder().build();
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
            postResponse.setDiscussion(discussionPostService.getByPostId(id1));
            postResponse.setFile(filePostService.getByPostId(id1));
        }

        return postResponses;
    }
}
