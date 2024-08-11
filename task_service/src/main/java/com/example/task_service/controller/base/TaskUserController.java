package com.example.task_service.controller.base;

import com.example.task_service.dto.TaskUserDto;
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
    public TaskUserEntity getTaskUserEntityById(@PathVariable Long taskId) {
        return taskService.getById(taskId);
    }

    @GetMapping("/parent/{taskId}")
    public List<TaskUserEntity> getTaskUserEntityByParentId(@PathVariable Long taskId) {
        return taskService.getByParentId(taskId);
    }

    @PostMapping("/{taskId}")
    public TaskUserEntity addTask(@PathVariable Long taskId, @RequestBody TaskUserDto taskDto) {
        return taskService.addTask(taskId, taskDto);
    }

    @PutMapping("/")
    public TaskUserEntity updateBaseTaskEntityById(@RequestBody TaskUserDto taskDto) {
        return taskService.updateAndCheck(taskDto);
    }
}