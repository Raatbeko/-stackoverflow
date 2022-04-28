package com.itacademy.stackoverflow.dto.comment.response;


import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentResponse {
    Long id;

    Long user_id;

    PostResponse post;

    List<DiscussionResponse> discussionRequests = new ArrayList<>();

    List<FileResponse> multipartFiles = new ArrayList<>();
}
