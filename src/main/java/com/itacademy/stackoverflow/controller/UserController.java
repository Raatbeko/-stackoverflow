package com.itacademy.stackoverflow.controller;

import com.itacademy.stackoverflow.dto.user.request.UserForAutoRequest;
import com.itacademy.stackoverflow.dto.user.request.UserRequest;
import com.itacademy.stackoverflow.dto.user.response.UserResponse;
import com.itacademy.stackoverflow.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request){
        return null;
    }

    @PostMapping("/autorithe")
    public String auto(@RequestBody UserForAutoRequest request){
        return null;
    }

    @GetMapping("/get-all-user")
    public List<UserResponse> getAll(){
        return null;
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id){
        return null;
    }

}
