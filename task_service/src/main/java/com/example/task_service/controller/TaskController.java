package com.example.task_service.controller;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.service.TaskProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TaskController {

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
}