package com.itacademy.stackoverflow.dto.like.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LikePostResponse {
    Long post_id;

    Long count_like;
}
