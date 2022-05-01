package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.FilePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilePostRepository extends JpaRepository<FilePostEntity,Long> {

    List<FilePostEntity> findByPostEntityId(Long id);
    List<FilePostEntity> findAllFileByPostEntityId(Long id);
}
