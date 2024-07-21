package com.example.task_service.controller.base;


import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.TaskUserDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.service.jpa.TaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task_user")
public class TaskUserController {

    @Autowired
    private TaskUserService taskService;

    @GetMapping("/{taskId}")
    public TaskUserEntity getBaseTaskEntityById(@PathVariable Long taskId) {
        return taskService.getById(taskId);
    }

    @PutMapping("/{baseTaskId}/{taskId}")
    public TaskUserEntity addTask(@PathVariable Long baseTaskId, @PathVariable Long taskId, @RequestBody TaskUserDto taskDto) {
        return taskService.addTask(baseTaskId, taskId, taskDto);
    }

    @PutMapping("/{taskId}")
    public TaskUserEntity update(@PathVariable Long taskId, @RequestBody TaskUserDto taskDto) {
        return taskService.update(taskId, taskDto);
    }
}