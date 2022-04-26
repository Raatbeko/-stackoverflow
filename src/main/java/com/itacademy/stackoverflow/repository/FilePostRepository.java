package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.FilePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilePostRepository extends JpaRepository<FilePostEntity,Long> {
}
