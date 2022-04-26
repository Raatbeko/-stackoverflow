package com.itacademy.stackoverflow.service.impl;

import com.itacademy.stackoverflow.dto.post.request.PostRequest;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.service.PostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostServiceImpl implements PostService {
    @Override
    public PostResponse save(PostRequest t) {
        return null;
    }

    @Override
    public List<PostResponse> getAll() {
        return null;
    }

    @Override
    public PostResponse findById(Long id) {
        return null;
    }
}
