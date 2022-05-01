package com.itacademy.stackoverflow.controller;

import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.service.LikePostService;
import com.itacademy.stackoverflow.service.PostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("den-dev/")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainController {
    final PostService postService;

    @GetMapping
    List<PostResponse> getAllPost() {
        return postService.getAll();
    }
}
