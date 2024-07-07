package com.example.controller.base;

import com.example.entity.UserEntity;
import com.example.service.jpa.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public UserEntity createTask(@RequestBody UserEntity userEntity) {
        return usersService.saveTask(userEntity);
    }

    @GetMapping
    public List<UserEntity> getAllTasks() {
        return usersService.getAllTasks();
    }

}