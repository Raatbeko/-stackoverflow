package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.DiscussionCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionCommentRepository extends JpaRepository<DiscussionCommentEntity,Long> {
}
