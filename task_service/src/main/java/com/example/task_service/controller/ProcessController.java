package com.example.task_service.controller;

import com.example.task_service.constant.CommandType;
import com.example.task_service.dto.KafkaMessage;
import com.example.task_service.kafka.KafkaProducerService;
import com.example.task_service.service.process.command.Command;
import com.example.task_service.service.process.command.CommandFactoryRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProcessController {

    private final KafkaProducerService<KafkaMessage> kafkaProducerService;

    @PostMapping("/start-process")
    public ResponseEntity<Boolean> startProcessKafka(@RequestBody KafkaMessage kafkaMessage) {
        try {
            kafkaProducerService.send("CamundaCreateUserTaskTopic", kafkaMessage);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception ex) {
            return ResponseEntity.ok(Boolean.FALSE);
        }
    }
    @PostMapping("/complete-task")
    public ResponseEntity<Boolean> completeTask(@RequestBody KafkaMessage kafkaMessage) {
        try {
            kafkaProducerService.send("CamundaCompleteUserTaskTopic", kafkaMessage);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception ex) {
            return ResponseEntity.ok(Boolean.FALSE);
        }
    }

}