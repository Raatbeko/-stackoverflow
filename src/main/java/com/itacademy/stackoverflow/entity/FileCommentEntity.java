package com.itacademy.stackoverflow.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "file_posts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileCommentEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "post_id")
    CommentEntity commentEntity;

    @ManyToOne
    @JoinColumn(name = "file_id")
    FileEntity fileEntity;
}
