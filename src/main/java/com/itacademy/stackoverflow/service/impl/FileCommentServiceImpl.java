package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.CommentEntity;
import com.itacademy.stackoverflow.entity.FileCommentEntity;
import com.itacademy.stackoverflow.entity.FileEntity;
import com.itacademy.stackoverflow.mapper.FileMapper;
import com.itacademy.stackoverflow.repository.FileCommentRepository;
import com.itacademy.stackoverflow.repository.FileRepository;
import com.itacademy.stackoverflow.service.FileCommentService;
import com.itacademy.stackoverflow.service.FileService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileCommentServiceImpl implements FileCommentService {

    final FileService fileService;
    final FileRepository fileRepository;
    final FileCommentRepository fileCommentRepository;

    @Override
    public List<FileResponse> save(List<FileRequest> fileRequests, CommentEntity commentEntity) {
        for (FileRequest fileRequest : fileRequests) {
            FileEntity fileEntity = FileMapper.INSTANCE.toFileResponse(fileService.save(fileRequest));
            fileCommentRepository
                    .save(FileCommentEntity.builder()
                            .fileEntity(fileEntity)
                            .commentEntity(commentEntity).build());
        }
        return FileMapper.INSTANCE.toFileResponse(fileRequests);
    }

    @Override
    public List<FileResponse> getByPostId(Long id) {
        List<FileResponse> fileResponses = new ArrayList<>();
        List<FileCommentEntity> commentEntities = fileCommentRepository.findByCommentEntityId(id);
        for (FileCommentEntity commentEntity : commentEntities) {
            fileResponses.add(FileMapper.INSTANCE.toFileResponse(fileRepository.getById(commentEntity.getFileEntity().getId())));
        }
        return fileResponses;
    }

    @Override
    public Boolean deleteAllFileByPostId(Long id) {
        return null;
    }
}
