package com.example.task_service.controller;

import com.example.task_service.constant.StatusTask;
import com.example.task_service.constant.TypeTaskProcess;
import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.CompleteUserTaskDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.process.TaskProcessService;
import com.example.task_service.service.process.impl.TaskProcessServiceDecorator;
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

    private final String SUCCESS = "Успешно";

    private final TaskProcessServiceDecorator taskProcessService;

    @PostMapping("/create_process")
    public ResponseEntity<BaseTaskEntity> createProcess(@RequestBody BaseTaskDto baseTaskDto) {
        return ResponseEntity.ok(taskProcessService.startProcess(baseTaskDto));
    }

    @PostMapping("/start_process")
    public ResponseEntity<String> startProcess(@RequestBody CompleteUserTaskDto completeUserTaskDto) {
        completeUserTaskDto.setNameProcess(TypeTaskProcess.START);
        taskProcessService.completeUserTask(completeUserTaskDto);
        return ResponseEntity.ok(SUCCESS);
    }

    @PostMapping("/complete_process")
    public ResponseEntity<String> completeProcess(@RequestBody CompleteUserTaskDto completeUserTaskDto) {
        completeUserTaskDto.setNameProcess(TypeTaskProcess.COMPLETE);
        taskProcessService.completeUserTask(completeUserTaskDto);
        return ResponseEntity.ok(SUCCESS);
    }

    @PostMapping("/cancel_process")
    public ResponseEntity<String> cancelProcess(@RequestBody CompleteUserTaskDto completeUserTaskDto) {
        completeUserTaskDto.setNameProcess(TypeTaskProcess.CANCEL);
        taskProcessService.completeUserTask(completeUserTaskDto);
        return ResponseEntity.ok(SUCCESS);
    }


}