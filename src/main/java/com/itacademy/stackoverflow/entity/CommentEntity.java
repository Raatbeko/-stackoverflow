package com.itacademy.stackoverflow.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;


}
