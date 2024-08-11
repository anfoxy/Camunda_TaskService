package com.example.task_service.controller;

import com.example.task_service.constant.TypeTaskProcess;
import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.CompleteProcessDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.entity.BaseTaskEntity;
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
    public ResponseEntity<Long> createProcess(@RequestBody StartProcessDto<BaseTaskDto> startProcessDto) {
        startProcessDto.setNameProcess(TypeTaskProcess.CREATE);
        return ResponseEntity.ok(taskProcessService.startProcess(startProcessDto));
    }

    @PostMapping("/start_process")
    public ResponseEntity<String> startProcess(@RequestBody CompleteProcessDto<BaseTaskDto> completeProcessDto) {
        completeProcessDto.setNameProcess(TypeTaskProcess.START);
        taskProcessService.completeUserTask(completeProcessDto);
        return ResponseEntity.ok(SUCCESS);
    }

    @PostMapping("/complete_process")
    public ResponseEntity<String> completeProcess(@RequestBody CompleteProcessDto<BaseTaskDto> completeProcessDto) {
        completeProcessDto.setNameProcess(TypeTaskProcess.COMPLETE);
        taskProcessService.completeUserTask(completeProcessDto);
        return ResponseEntity.ok(SUCCESS);
    }

    @PostMapping("/cancel_process")
    public ResponseEntity<String> cancelProcess(@RequestBody CompleteProcessDto<BaseTaskDto> completeProcessDto) {
        completeProcessDto.setNameProcess(TypeTaskProcess.CANCEL);
        taskProcessService.completeUserTask(completeProcessDto);
        return ResponseEntity.ok(SUCCESS);
    }


}