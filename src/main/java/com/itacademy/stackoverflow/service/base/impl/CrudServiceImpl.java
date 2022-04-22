package com.itacademy.stackoverflow.service.base.impl;

import com.itacademy.stackoverflow.service.base.CrudService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
public class CrudServiceImpl<Entity,Response, Request> implements CrudService<Entity,Response,Request> {
    final CrudRepository<Entity, Long> crudRepository;
    @Override
    public Response saveOrUpdate(Request t) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }

    @Override
    public Response getById(Long id) {
        return null;
    }

    @Override
    public List<Response> findAll() {
        return null;
    }

    public CrudServiceImpl(CrudRepository<Entity, Long> crudRepository) {
        this.crudRepository = crudRepository;
    }
}
