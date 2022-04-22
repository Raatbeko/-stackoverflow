package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity,Long> {
}
