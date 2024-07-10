package com.example.camunda.service;

import com.example.camunda.dto.BaseTaskDto;
import com.example.camunda.dto.CompleteUserTaskDto;

public interface TaskProcessService {
    String startProcess(BaseTaskDto baseTaskDto);
    void completeUserTask(CompleteUserTaskDto completeUserTaskDto);
}
