package com.itacademy.stackoverflow.controller;

import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.dto.post.request.PostRequest;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.service.CommentService;
import com.itacademy.stackoverflow.service.PostService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @PostMapping("/{id-user}/add-post")
    public PostResponse save(@PathVariable("id-user") Long id,
                             @RequestBody PostRequest request) {
        return null;
    }

    @GetMapping("{id}")
    public PostResponse getById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping("{id-post}/comment")
    public List<CommentResponse> getPostComment(@PathVariable("id-post") Long id) {
        return null;
    }

    @DeleteMapping("{id-post}/delete-post")
    public String delete(@PathVariable("id-post")Long id,
                         @RequestBody PostRequest postRequest) {
        return null;
    }

    @GetMapping
    public List<PostResponse> getAll() {
        return null;
    }

    @PostMapping("add-comment")
    public CommentResponse addComment() {
        return null;
    }
}
