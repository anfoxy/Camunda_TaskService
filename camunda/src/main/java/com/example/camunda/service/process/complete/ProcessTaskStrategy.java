package com.example.camunda.service.process.complete;

import com.example.camunda.dto.CompleteUserTaskDto;

public interface ProcessTaskStrategy {

    void execute(CompleteUserTaskDto completeUserTaskDto);
}
