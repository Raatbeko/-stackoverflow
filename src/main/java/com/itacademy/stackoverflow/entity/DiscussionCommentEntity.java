package com.itacademy.stackoverflow.entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "discussion_comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscussionCommentEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "comment_id")
    CommentEntity commentEntity;

    @ManyToOne
    @JoinColumn(name = "discussion_id")
    DiscussionEntity discussionEntity;
}
