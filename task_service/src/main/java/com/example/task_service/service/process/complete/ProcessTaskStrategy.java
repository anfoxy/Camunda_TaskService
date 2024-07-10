package com.example.task_service.service.process.complete;

import com.example.task_service.dto.CompleteUserTaskDto;

public interface ProcessTaskStrategy {

    void execute(CompleteUserTaskDto completeUserTaskDto);
}
