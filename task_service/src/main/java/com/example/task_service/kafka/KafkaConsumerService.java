package com.example.task_service.kafka;

import com.example.task_service.dto.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {
    @KafkaListener(topics = {"topic-name"}, groupId = "topic-name")
    public void consume(KafkaMessage myMsg) {
        log.info(String.format("!!!!!!!!!!!!!!!!!!Received: " + myMsg));
    }
}