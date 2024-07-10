package com.example.task_service.service;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.CompleteUserTaskDto;

public interface TaskProcessService {
    String startProcess(BaseTaskDto baseTaskDto);
    void completeUserTask(CompleteUserTaskDto completeUserTaskDto);
}
