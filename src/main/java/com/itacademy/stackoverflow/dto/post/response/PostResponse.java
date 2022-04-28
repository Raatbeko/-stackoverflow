package com.itacademy.stackoverflow.dto.post.response;

import com.itacademy.stackoverflow.dto.discussion.response.DiscussionResponse;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse{
    String header;

    Long user_id;

    List<DiscussionResponse> discussion = new ArrayList<>();

    List<FileResponse> file = new ArrayList<>();
}
