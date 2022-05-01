package com.itacademy.stackoverflow.dto.discussion.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscussionResponse {
    Long id;

    String discussion;
}
