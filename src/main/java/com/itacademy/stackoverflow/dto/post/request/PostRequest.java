package com.itacademy.stackoverflow.dto.post.request;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostRequest {
    String header;

    Long  user_id;

    List<DiscussionRequest> discussionRequests = new ArrayList<>();

    List<FileRequest> fileRequests = new ArrayList<>();
}
