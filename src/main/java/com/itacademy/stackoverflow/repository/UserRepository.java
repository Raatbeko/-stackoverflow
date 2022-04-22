package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
