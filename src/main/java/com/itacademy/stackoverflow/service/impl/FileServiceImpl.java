package com.itacademy.stackoverflow.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.entity.FileEntity;
import com.itacademy.stackoverflow.enums.FileType;
import com.itacademy.stackoverflow.exception.FileNotFoundException;
import com.itacademy.stackoverflow.repository.FileRepository;
import com.itacademy.stackoverflow.service.FileService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileServiceImpl implements FileService {
    @Autowired
    FileRepository fileRepository;

    final static String CLOUDINARY_URL = "CLOUDINARY_URL=cloudinary://379513361635134:yG00u8tW6g3_Hv1OK0QpVj7ZM0w@doltdryzx";

    @Override
    public FileResponse save(FileRequest t) {
        File file;
        try {
            String filename = UUID.randomUUID().toString();
            file = Files.createTempFile(System.currentTimeMillis() + "", Objects.requireNonNull(t.getMultipartFile().getOriginalFilename())
                    .substring(t.getMultipartFile().getOriginalFilename().length()-4)).toFile();
            t.getMultipartFile().transferTo(file);

            Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap());

            FileEntity fileEntity = FileEntity.builder()
                    .fileType(FileType.IMG)
                    .name(t.getMultipartFile().getName())
                    .url((String)uploadResult.get("url") ).build();

            return FileResponse.builder()
                    .id(fileEntity.getId())
                    .url(fileEntity.getUrl()).build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<FileResponse> getAll() {
        List<FileEntity> fileEntities = fileRepository.findAll();
        List<FileResponse> fileResponses = new ArrayList<>();

        for (FileEntity fileEntity : fileEntities) {

            fileResponses.add(FileResponse.builder()
                    .id(fileEntity.getId())
                    .url(fileEntity.getUrl()).build());

        }

        return fileResponses;
    }

    @Override
    public FileResponse findById(Long id) {
        FileEntity fileEntity = fileRepository.getById(id);
        if (fileEntity == null) throw new FileNotFoundException("file not found", HttpStatus.NOT_FOUND);
        return FileResponse.builder()
                .id(fileEntity.getId())
                .url(fileEntity.getUrl())
                .build();
    }
}
