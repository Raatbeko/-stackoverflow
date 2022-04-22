package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<FileEntity,Long> {
}
