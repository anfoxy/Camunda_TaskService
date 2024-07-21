package com.example.camunda.controller;

import com.example.camunda.model.KafkaMessage;
import com.example.camunda.service.TaskProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskProcessService taskProcessService;

    @PostMapping("/start-process")
    public ResponseEntity<String> startProcess(@RequestBody KafkaMessage message) {
        String id = taskProcessService.startProcess(message);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/complete-task")
    public ResponseEntity<String> completeTask(@RequestBody KafkaMessage message) {
        taskProcessService.completeUserTask(message);
        return ResponseEntity.ok("Task completed");
    }
}