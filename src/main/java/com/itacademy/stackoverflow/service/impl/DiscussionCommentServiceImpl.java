package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.entity.CommentEntity;
import com.itacademy.stackoverflow.entity.DiscussionCommentEntity;
import com.itacademy.stackoverflow.entity.DiscussionEntity;
import com.itacademy.stackoverflow.mapper.DiscussionMapper;
import com.itacademy.stackoverflow.repository.DiscussionCommentRepository;
import com.itacademy.stackoverflow.repository.DiscussionRepository;
import com.itacademy.stackoverflow.service.DiscussionCommentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class DiscussionCommentServiceImpl implements DiscussionCommentService {

    final DiscussionRepository discussionRepository;

    final DiscussionCommentRepository discussionCommentRepository;

    @Override
    public Boolean save(List<DiscussionRequest> discussionRequests, CommentEntity commentEntity) {
        for (DiscussionRequest discussionRequest : discussionRequests) {
            DiscussionEntity discussionEntity = discussionRepository.save(DiscussionMapper.INSTANCE.toDiscussionRequest(discussionRequest));
            discussionCommentRepository
                    .save(DiscussionCommentEntity.builder()
                            .discussionEntity(discussionEntity)
                            .commentEntity(commentEntity).build());
        }
        return commentEntity == null;
    }

    @Override
    public List<DiscussionResponse> getByCommentId(Long id) {
        List<DiscussionResponse> discussionResponses = new ArrayList<>();
        List<DiscussionCommentEntity> discussionCommentEntities = discussionCommentRepository.findByCommentEntityId(id);
        for (DiscussionCommentEntity discussionCommentEntity : discussionCommentEntities) {
            discussionResponses
                    .add(DiscussionMapper.INSTANCE.toDiscussionResponse(discussionRepository
                            .getById(discussionCommentEntity.getDiscussionEntity().getId())));
        }
        return discussionResponses;
    }

    @Override
    public Boolean deleteAllDiscussionByCommentId(Long id) {
        return null;
    }
}
