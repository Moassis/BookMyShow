package com.example.Book_my_show_backend.Controllers;

import com.example.Book_my_show_backend.Dtos.UserRequestDto;
import com.example.Book_my_show_backend.Models.UserEntity;
import com.example.Book_my_show_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto) {

        return userService.createUser(userRequestDto);

    }

    @GetMapping("/{name}")
    public UserEntity getUserByName(@PathVariable String name) {
        UserEntity user = userService.getUserByName(name);
        return user;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return users;
    }

}
