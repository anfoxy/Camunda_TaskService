package com.example.camunda.kafka.listener;

import com.example.camunda.constant.TypeTaskProcess;
import com.example.camunda.dto.KafkaMessage;
import com.example.camunda.exception.TaskServiceException;
import com.example.camunda.receive.CamundaMessageSender;
import com.example.camunda.service.TaskProcessService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompleteUserTaskTopicListener {

    private final TaskProcessService taskProcessService;
    private final CamundaMessageSender camundaMessageSender;
    private static final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = {"${spring.kafka.topic.camundaCompleteUserTaskTopic}"}, groupId = "topic-name")
    public void completeUserTask(String message) {
        try {
            KafkaMessage kafkaMessage = mapper.readValue(message, KafkaMessage.class);
            if (kafkaMessage.getStatus().equals(TypeTaskProcess.CANCEL)) {
                camundaMessageSender.sendTerminateMessage(kafkaMessage.getId());
            } else {
                taskProcessService.completeUserTask(kafkaMessage);
            }
        } catch (JsonProcessingException e) {
            throw new TaskServiceException("Не удалось прочитать сообщение на завершение задачи" + message);
        }
    }
}
