package com.itacademy.stackoverflow.dto.post.request;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.file.request.FileRequest;
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
public class PostRequest {
    @NotNull
    String header;

    @NotNull
    Long userId;

    List<DiscussionRequest> discussionRequests = new ArrayList<>();

    List<FileRequest> fileRequests = new ArrayList<>();
}
