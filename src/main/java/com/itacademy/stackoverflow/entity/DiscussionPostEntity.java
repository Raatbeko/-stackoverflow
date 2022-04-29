package com.itacademy.stackoverflow.entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "discussion_post")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscussionPostEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "post_id")
    PostEntity postEntity;

    @ManyToOne
    @JoinColumn(name = "discussion_id")
    DiscussionEntity discussionEntity;
}
