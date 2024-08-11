package com.example.task_service.kafka.listener;

import com.example.task_service.dto.UserTaskDto;
import com.example.task_service.exception.TaskServiceException;
import com.example.task_service.service.process.camunda.PrepareTaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrepareTasksTopicListener {

   private final PrepareTaskService prepareTaskService;
   private static final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = { "${spring.kafka.topic.prepareTasksTopic}"}, groupId = "topic-name")
    public void completeUserTask(String message) {
        try {
            UserTaskDto kafkaMessage = mapper.readValue(message, UserTaskDto.class);
            prepareTaskService.prepareTask(kafkaMessage);
        } catch (JsonProcessingException e) {
            throw new TaskServiceException("Не удалось прочитать сообщение на завершение задачи" + message);
        }
    }
}
