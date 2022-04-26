package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.FileCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileCommentRepository extends JpaRepository<FileCommentEntity,Long> {
}
