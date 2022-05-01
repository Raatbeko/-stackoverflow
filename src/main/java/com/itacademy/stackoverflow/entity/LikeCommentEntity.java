package com.itacademy.stackoverflow.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "like_comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LikeCommentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "post_id")
    CommentEntity commentEntity;
}
