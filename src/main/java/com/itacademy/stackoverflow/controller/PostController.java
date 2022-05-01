package com.itacademy.stackoverflow.controller;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.dto.post.request.PostRequest;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.service.CommentService;
import com.itacademy.stackoverflow.service.PostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostController {
    final
    PostService postService;

    final
    CommentService commentService;


    @PostMapping("/add-post")
    public PostResponse save(@RequestBody PostRequest request) {
        return postService.save(request);
    }

    @GetMapping("{id}")
    public PostResponse getById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("{id-comment}/delete-comment")
    public CommentResponse deleteComment(@PathVariable("id-comment") Long id){
        return commentService.delete(id);
    }

    @DeleteMapping("{id-post}/delete-post")
    public PostResponse deletePost(@PathVariable("id-post") Long id) {
        return postService.delete(id);
    }

    @GetMapping
    public List<PostResponse> getAll() {
        return postService.getAll();
    }

    @PostMapping("/add-comment")
    public CommentResponse addComment(@RequestBody CommentRequest commentRequest) {
        return commentService.save(commentRequest);
    }
}
