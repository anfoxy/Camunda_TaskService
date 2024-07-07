package com.example.service.process.start;

import com.example.dto.BaseTaskDto;
import com.example.entity.BaseTaskEntity;

public interface CreateDraftBaseTask {

    public BaseTaskEntity createDraftTask(BaseTaskDto baseTaskDto);

}
