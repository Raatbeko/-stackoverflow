package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.DiscussionPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionPostRepository extends JpaRepository<DiscussionPostEntity,Long> {
}
