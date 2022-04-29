package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.FileCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FileCommentRepository extends JpaRepository<FileCommentEntity,Long> {
    @Query(nativeQuery = true,value = "select f.file_id from file_comment f where f.comment_id =:id")
    Long getByCommentEntityId(Long id);
}
