package com.example.task_service.controller.base;

import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.exception.TaskServiceNotFoundException;
import com.example.task_service.service.jpa.BaseTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/base-tasks")
public class BaseTaskController {

    @Autowired
    private BaseTaskService baseTaskService;

    @GetMapping("/{taskId}")
    public BaseTaskEntity getBaseTaskEntityById(@PathVariable Long taskId) {
        return baseTaskService.getById(taskId);
    }

}