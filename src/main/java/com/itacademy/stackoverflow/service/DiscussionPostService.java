package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.entity.DiscussionPostEntity;
import com.itacademy.stackoverflow.entity.PostEntity;

import java.util.List;

public interface DiscussionPostService {

    Boolean save(List<DiscussionRequest> discussion, PostEntity postEntity);

    List<DiscussionResponse> getByPostId(Long id);

    Boolean deleteAllDiscussionByPostId(Long id);

}
