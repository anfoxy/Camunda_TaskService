package com.example.camunda.kafka;

import com.example.camunda.exception.TaskServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService<T> {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();
    public void send(String topicName, T value) {
        try {
            String message = mapper.writeValueAsString(value);
            var future = kafkaTemplate.send(topicName, message);
            future.whenComplete((sendResult, exception) -> {
                if (exception != null) {
                    future.completeExceptionally(exception);
                } else {
                    future.complete(sendResult);
                }
                log.info(String.format("Task status send to Kafka topic : %s, Object: ", topicName) + value);
            });
        } catch (JsonProcessingException e) {
            throw new TaskServiceException(String.format("Не удалось преобразовать объект к строке %s", e.getMessage()));
        }
    }
}
