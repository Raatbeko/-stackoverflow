package com.itacademy.stackoverflow.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "like_posts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LikePostEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "post_id")
    PostEntity postEntity;
}
