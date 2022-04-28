package com.itacademy.stackoverflow.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "like_posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LikePostEntity extends BaseEntity{
    @Column(name = "user_id")
    UserEntity userEntity;

    @Column(name = "post_id")
    PostEntity entity;
}
