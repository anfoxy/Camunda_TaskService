package com.example.task_service.service.process.start;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.entity.BaseTaskEntity;

public interface CreateDraftBaseTask {

    public BaseTaskEntity createDraftTask(BaseTaskDto baseTaskDto);

}
