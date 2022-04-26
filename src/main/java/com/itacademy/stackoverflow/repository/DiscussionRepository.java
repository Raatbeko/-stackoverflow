package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.DiscussionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends JpaRepository<DiscussionEntity,Long> {
}
