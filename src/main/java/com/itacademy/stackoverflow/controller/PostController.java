package com.itacademy.stackoverflow.controller;

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
@RequestMapping("/post")
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
