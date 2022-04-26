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

    @PostMapping("/add-post")
    public PostResponse save(PostRequest request) {
        return null;
    }

    @GetMapping("/get-comment-post")
    public List<CommentResponse> getPostComment(){
        return null;
    }

    @DeleteMapping("/delete-post")
    public String delete(PostRequest postRequest){
        return null;
    }

    @GetMapping("get-all-post")
    public List<PostResponse> getAll(){
        return null;
    }
}
