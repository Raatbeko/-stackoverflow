package com.itacademy.stackoverflow.controller;

import com.itacademy.stackoverflow.dto.comment.request.CommentRequest;
import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.service.CommentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/add-comment")
    public CommentResponse saveComment(@RequestBody CommentRequest request) {
        return null;
    }

    @GetMapping("/{id}")
    public CommentResponse getById(@PathVariable("id") Long id) {
        return null;
    }

    @DeleteMapping("/delete-comment")
    public CommentResponse delete(@RequestBody CommentRequest request) {
        return null;
    }

    @GetMapping("/get-all-comment")
    public List<CommentResponse> getAll() {
        return null;
    }

}
