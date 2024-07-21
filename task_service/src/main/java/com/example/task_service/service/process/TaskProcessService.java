package com.example.task_service.service.process;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.CompleteUserTaskDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.dto.TaskUserDto;
import com.example.task_service.entity.BaseTaskEntity;

public interface TaskProcessService {
    BaseTaskEntity startProcess(BaseTaskDto baseTaskDto);
    void completeUserTask(CompleteUserTaskDto completeUserTaskDto);
}
