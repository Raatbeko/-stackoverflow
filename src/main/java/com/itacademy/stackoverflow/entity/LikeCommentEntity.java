package com.itacademy.stackoverflow.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "like_comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LikeCommentEntity extends BaseEntity {

    @Column(name = "user_id")
    UserEntity userEntity;

    @Column(name = "comment_id")
    CommentEntity commentEntity;
}
