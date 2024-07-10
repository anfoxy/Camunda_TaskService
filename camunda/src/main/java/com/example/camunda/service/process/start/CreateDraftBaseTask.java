package com.example.camunda.service.process.start;

import com.example.camunda.dto.BaseTaskDto;
import com.example.camunda.entity.BaseTaskEntity;

public interface CreateDraftBaseTask {

    public BaseTaskEntity createDraftTask(BaseTaskDto baseTaskDto);

}
