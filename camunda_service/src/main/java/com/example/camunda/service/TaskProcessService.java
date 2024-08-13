package com.example.camunda.service;

import com.example.camunda.dto.KafkaMessage;

public interface TaskProcessService {
    String startProcess(KafkaMessage message);
    void completeUserTask(KafkaMessage message);
    void updateTime(KafkaMessage message);
}
