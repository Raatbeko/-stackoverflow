package com.itacademy.stackoverflow.dto.post.request;

import com.itacademy.stackoverflow.dto.discussion.request.DiscussionRequest;
import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import java.util.List;

@Jacksonized //missing
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostRequest {

    String header;

    Long userId;

    List<DiscussionRequest> discussionRequests ;

    List<FileRequest> fileRequests;
}
