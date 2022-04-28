package com.itacademy.stackoverflow.mapper;

import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.FileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    FileEntity toFileResponse(FileResponse fileResponse);
}
