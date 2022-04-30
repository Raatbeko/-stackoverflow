package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.entity.CommentEntity;
import com.itacademy.stackoverflow.entity.DiscussionCommentEntity;

import java.util.List;

public interface DiscussionCommentService {

    Boolean save(List<DiscussionRequest> discussionRequests, CommentEntity commentEntity);

    List<DiscussionResponse> getByCommentId(Long id);

    Boolean deleteAllDiscussionByCommentId(Long id);
}
