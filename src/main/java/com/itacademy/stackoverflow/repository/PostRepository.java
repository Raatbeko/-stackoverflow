package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
    @Query(nativeQuery = true, value = "select * from posts p where header like :header"+"%")
    List<PostEntity> searchByHeader(String header);

    List<PostEntity> findByUserEntityId(Long id);

}
