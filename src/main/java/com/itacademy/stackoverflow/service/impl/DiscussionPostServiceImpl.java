package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.entity.DiscussionEntity;
import com.itacademy.stackoverflow.entity.DiscussionPostEntity;
import com.itacademy.stackoverflow.entity.PostEntity;
import com.itacademy.stackoverflow.mapper.DiscussionMapper;
import com.itacademy.stackoverflow.repository.DiscussionPostRepository;
import com.itacademy.stackoverflow.repository.DiscussionRepository;
import com.itacademy.stackoverflow.service.DiscussionPostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class DiscussionPostServiceImpl implements DiscussionPostService {

    final DiscussionRepository discussionRepository;

    final DiscussionPostRepository discussionPostRepository;

    @Override
    public Boolean save(List<DiscussionRequest> discussion, PostEntity postEntity) {

        for (DiscussionRequest discussions : discussion) {
            DiscussionEntity discussionEntity1 = discussionRepository.save(DiscussionMapper.INSTANCE.toDiscussionRequest(discussions));
            discussionPostRepository
                    .save(DiscussionPostEntity.builder()
                            .postEntity(postEntity)
                            .discussionEntity(discussionEntity1).build());
        }
        return  postEntity == null;
    }

    @Override
    public List<DiscussionResponse> getByPostId(Long id) {
        List<DiscussionResponse> discussionResponses = new ArrayList<>();
        List<DiscussionPostEntity> discussionPostEntities = discussionPostRepository.findByPostEntityId(id);
        for (DiscussionPostEntity discussionPostEntity : discussionPostEntities) {
            DiscussionResponse discussionResponse = DiscussionMapper.INSTANCE.toDiscussionResponse(discussionRepository.getById(id));
            discussionResponses.add(discussionResponse);
        }
        return discussionResponses;
    }

    @Override
    public Boolean deleteAllDiscussionByPostId(Long id) {
        return null;
    }
}
