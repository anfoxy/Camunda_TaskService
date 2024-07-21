package com.example.camunda.listener;

import com.example.camunda.model.KafkaMessage;
import com.example.camunda.service.TaskProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateUserTaskTopicListener {

    private final TaskProcessService taskProcessService;
    @KafkaListener(topics = {"CamundaCreateUserTaskTopic"}, groupId = "topic-name")
    public void startProcess(KafkaMessage message) {
        taskProcessService.startProcess(message);
    }
}