package com.example.service;

import com.example.dto.BaseTaskDto;
import com.example.dto.CompleteUserTaskDto;

public interface TaskProcessService {
    String startProcess(BaseTaskDto baseTaskDto);
    void completeUserTask(CompleteUserTaskDto completeUserTaskDto);
}
