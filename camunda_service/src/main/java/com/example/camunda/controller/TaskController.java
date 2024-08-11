package com.example.camunda.controller;

import com.example.camunda.dto.KafkaMessage;
import com.example.camunda.receive.CamundaMessageSender;
import com.example.camunda.service.TaskProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskProcessService taskProcessService;
    private final CamundaMessageSender camundaMessageSender;

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
    @GetMapping("/templete/{taskId}")
    public void getBaseTaskEntityByUserId(@PathVariable String taskId) {
         camundaMessageSender.sendTerminateMessage(taskId);
    }

}