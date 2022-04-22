package com.itacademy.stackoverflow.dto.comment.response;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.entity.CommentEntity;
import com.itacademy.stackoverflow.service.CommentService;
import com.itacademy.stackoverflow.service.base.impl.CrudServiceImpl;
import org.springframework.data.repository.CrudRepository;

public class CommentResponse extends CrudServiceImpl<CommentEntity,CommentResponse, CommentRequest> implements CommentService  {
    public CommentResponse(CrudRepository<CommentEntity, Long> crudRepository) {
        super(crudRepository);
    }

}
