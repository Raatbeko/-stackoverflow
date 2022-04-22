package com.itacademy.stackoverflow.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostEntity extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    CommentEntity comment;

    @Column(name = "header",nullable = false)
    String header;

    @Column(name = "discussion",nullable = false)
    ArrayList<String> discussion;

    @Column(name = "file",nullable = false)
    ArrayList<FileEntity> fileEntities;
}
