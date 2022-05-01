package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.LikeCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeCommentEntity, Long> {

    Long countLikeCommentEntityById(Long id);

    LikeCommentEntity getByCommentEntityId(Long id);
    
}
