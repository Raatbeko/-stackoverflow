package com.itacademy.stackoverflow.mapper;

import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.FileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    FileEntity toFileResponse(FileResponse fileResponse);

    FileResponse toFileResponse(FileEntity fileEntity);

    List<FileResponse> toFileResponse(List<FileRequest> fileRequests);
}
