package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.CommentEntity;
import com.itacademy.stackoverflow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    List<CommentEntity> findByPostId(Long id);
}
