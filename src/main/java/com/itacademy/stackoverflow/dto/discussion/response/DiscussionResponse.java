package com.itacademy.stackoverflow.dto.discussion.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscussionResponse {
    Long id;

    String discussion;
}
