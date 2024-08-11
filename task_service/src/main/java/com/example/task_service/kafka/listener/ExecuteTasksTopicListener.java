package com.example.task_service.kafka.listener;

import com.example.task_service.dto.ServiceTaskDto;
import com.example.task_service.exception.TaskServiceException;
import com.example.task_service.service.process.camunda.ExecuteTasksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExecuteTasksTopicListener {

    private final ExecuteTasksService executeTasksService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = {"${spring.kafka.topic.executeTasksTopic}"}, groupId = "topic-name")
    public void startProcess(String message) {
        try {
            ServiceTaskDto kafkaMessage = mapper.readValue(message, ServiceTaskDto.class);
            executeTasksService.executeTask(kafkaMessage);
        } catch (JsonProcessingException e) {
            throw new TaskServiceException("Не удалось прочитать сообщение на завершение задачи" + message);
        }
    }
}
