package com.itacademy.stackoverflow.service;


import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.FilePostEntity;
import com.itacademy.stackoverflow.entity.PostEntity;

import java.util.List;

public interface FilePostService {

    Boolean save(List<FileRequest> discussionEntity, PostEntity postEntity);

    List<FileResponse> getByPostId(Long id);

    Boolean deleteAllFileByPostId(Long id);
}
