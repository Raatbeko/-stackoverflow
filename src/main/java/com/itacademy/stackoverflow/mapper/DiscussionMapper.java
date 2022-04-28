package com.itacademy.stackoverflow.mapper;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.entity.DiscussionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscussionMapper {
    DiscussionMapper INSTANCE = Mappers.getMapper(DiscussionMapper.class);

    DiscussionEntity toDiscussionRequest(DiscussionRequest discussionRequest);
}
