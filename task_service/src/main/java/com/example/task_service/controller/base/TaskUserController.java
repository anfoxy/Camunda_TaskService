package com.example.task_service.controller.base;


import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.service.jpa.TaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task_user")
public class TaskUserController {

    @Autowired
    private TaskUserService taskService;

    @PostMapping
    public TaskUserEntity createTask(@RequestBody TaskUserEntity task) {
        return taskService.saveTask(task);
    }

    @GetMapping
    public List<TaskUserEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

}