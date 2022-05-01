package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.LikePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikePostRepository extends JpaRepository<LikePostEntity,Long> {

    Long countLikePostEntityById(Long id);

    LikePostEntity getByPostEntityId(Long id);

}
