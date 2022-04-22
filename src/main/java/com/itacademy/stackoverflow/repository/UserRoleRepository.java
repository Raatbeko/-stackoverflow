package com.itacademy.stackoverflow.repository;

import com.itacademy.stackoverflow.entity.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity,Long> {
}
