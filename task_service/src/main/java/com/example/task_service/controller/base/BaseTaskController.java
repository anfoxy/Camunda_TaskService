package com.example.task_service.controller.base;

import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.jpa.BaseTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/base-tasks")
public class BaseTaskController {

    @Autowired
    private BaseTaskService baseTaskService;

    @PostMapping
    public BaseTaskEntity createBaseTask(@RequestBody BaseTaskEntity baseTask) {
        return baseTaskService.saveBaseTask(baseTask);
    }

    @GetMapping
    public List<BaseTaskEntity> getAllBaseTasks() {
        return baseTaskService.getAllBaseTasks();
    }

}