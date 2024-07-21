package com.example.camunda.service;

import com.example.camunda.model.KafkaMessage;

public interface TaskProcessService {
    String startProcess(KafkaMessage message);
    void completeUserTask(KafkaMessage message);
}
