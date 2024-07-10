package com.example.camunda.controller;

import com.example.camunda.dto.BaseTaskDto;
import com.example.camunda.service.TaskProcessService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final RuntimeService runtimeService;
    private final TaskProcessService taskProcessService;

    @PostMapping("/create_process")
    public ResponseEntity<String> createProcess(@RequestBody BaseTaskDto baseTaskDto) {
        return ResponseEntity.ok(taskProcessService.startProcess(baseTaskDto));
    }

    @PostMapping("/start_process")
    public ResponseEntity<String> startProcess(@RequestBody BaseTaskDto baseTaskDto) {



        return ResponseEntity.ok(null);
    }

    @PostMapping("/complete_process")
    public ResponseEntity<String>completeProcess(@RequestBody BaseTaskDto baseTaskDto) {


        return ResponseEntity.ok(null);
    }

    @PostMapping("/cancel_process")
    public ResponseEntity<String> cancelProcess(@RequestBody BaseTaskDto baseTaskDto) {



        return ResponseEntity.ok(null);
    }

    @PostMapping("/complete-task/{taskId}")
    public ResponseEntity<String> completeTask(@PathVariable String taskId) {
        String processInstanceId = taskService.createTaskQuery()
                .processInstanceId(taskId)
                .active().singleResult().getId();
        taskService.complete(processInstanceId);
        return ResponseEntity.ok("Task completed");
    }
}