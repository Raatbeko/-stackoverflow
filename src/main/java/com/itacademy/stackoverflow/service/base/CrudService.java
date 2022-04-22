package com.itacademy.stackoverflow.service.base;

import java.util.List;

public interface CrudService<Entity,Response,Request> {
    Response saveOrUpdate(Request t);

    Response delete(Long id);

    Response getById(Long id);

    List<Response> findAll();
}
