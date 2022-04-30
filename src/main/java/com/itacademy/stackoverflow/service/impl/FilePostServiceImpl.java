package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.FileEntity;
import com.itacademy.stackoverflow.entity.FilePostEntity;
import com.itacademy.stackoverflow.entity.PostEntity;
import com.itacademy.stackoverflow.mapper.FileMapper;
import com.itacademy.stackoverflow.repository.FilePostRepository;
import com.itacademy.stackoverflow.repository.FileRepository;
import com.itacademy.stackoverflow.service.FilePostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilePostServiceImpl implements FilePostService {

    final FileRepository fileRepository;

    final FileServiceImpl fileService;

    final FilePostRepository filePostRepository;

    @Override
    public Boolean save(List<FileRequest> fileRequests, PostEntity postEntity) {
        for (FileRequest fileRequest : fileRequests) {
            FileEntity fileEntity = FileMapper.INSTANCE.toFileResponse(fileService.save(fileRequest));
            filePostRepository
                    .save(FilePostEntity.builder()
                            .postEntity(postEntity)
                            .fileEntity(fileEntity).build());
        }
        return postEntity == null;
    }

    @Override
    public List<FileResponse> getByPostId(Long id) {
        List<FileResponse> fileResponses = new ArrayList<>();
        List<FilePostEntity> filePostEntities = filePostRepository.findByPostEntityId(id);
        for (FilePostEntity filePostEntity : filePostEntities) {
            fileResponses
                    .add(FileMapper.INSTANCE.toFileResponse(fileRepository.getById(filePostEntity.getId())));
        }
        return fileResponses;
    }

    @Override
    public Boolean deleteAllFileByPostId(Long id) {
        return null;
    }
}
