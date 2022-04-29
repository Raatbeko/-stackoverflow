package com.itacademy.stackoverflow.dto.post.response;

import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse{
    String header;

    Long userId;

    List<DiscussionResponse> discussion ;

    List<FileResponse> file ;

    List<CommentResponse> commentResponses;
}
