package com.itacademy.stackoverflow.service;

import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.CommentEntity;
import com.itacademy.stackoverflow.entity.FileCommentEntity;

import java.util.List;

public interface FileCommentService {
    List<FileResponse> save(List<FileRequest> discussionEntity, CommentEntity commentEntity);

    List<FileResponse> getByCommentId(Long id);

    Boolean deleteAllFileByCommentId(Long id);
}
