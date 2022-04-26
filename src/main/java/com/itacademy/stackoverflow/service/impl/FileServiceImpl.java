package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.file.request.FileRequest;
import com.itacademy.stackoverflow.dto.file.response.FileResponse;
import com.itacademy.stackoverflow.service.FileService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileServiceImpl implements FileService {
    @Override
    public FileResponse save(FileRequest t) {
        return null;
    }

    @Override
    public List<FileResponse> getAll() {
        return null;
    }

    @Override
    public FileResponse findById(Long id) {
        return null;
    }
}
