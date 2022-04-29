package com.itacademy.stackoverflow.dto.comment.request;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.dto.user.response.UserResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentRequest {

    @NotNull
    Long userId;

    @NotNull
    Long postId;

    Long countLike;

    List<DiscussionRequest> discussionRequests = new ArrayList<>();

    List<FileRequest> multipartFiles = new ArrayList<>();
}
