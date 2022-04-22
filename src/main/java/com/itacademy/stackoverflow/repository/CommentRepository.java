package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity,Long> {
}
