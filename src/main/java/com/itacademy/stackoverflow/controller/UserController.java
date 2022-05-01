package com.itacademy.stackoverflow.controller;

import com.itacademy.stackoverflow.dto.comment.response.CommentResponse;
import com.itacademy.stackoverflow.dto.post.response.PostResponse;
import com.itacademy.stackoverflow.dto.user.request.UserAuthRequest;
import com.itacademy.stackoverflow.dto.user.request.UserRequest;
import com.itacademy.stackoverflow.dto.user.response.UserResponse;
import com.itacademy.stackoverflow.service.CommentService;
import com.itacademy.stackoverflow.service.PostService;
import com.itacademy.stackoverflow.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    final PostService service;

    final CommentService commentService;


    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request) {
        return userService.save(request);
    }

    @SneakyThrows
    @PostMapping("/auto")
    public String auto(@RequestBody UserAuthRequest request) {
        return userService.getToken(request);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostResponse> getAllPost(@PathVariable("id") Long id) {
        return service.getPostByUserId(id);
    }

    @GetMapping("{id}/comments")
    public List<CommentResponse> getAllComment(@PathVariable("id") Long id) {
        return commentService.getAllByUserId(id);
    }



}
