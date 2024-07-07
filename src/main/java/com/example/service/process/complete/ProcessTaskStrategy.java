package com.example.service.process.complete;

import com.example.dto.CompleteUserTaskDto;

public interface ProcessTaskStrategy {

    void execute(CompleteUserTaskDto completeUserTaskDto);
}
