package com.example.task_service.service.process.complete;

import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.CompleteProcessDto;

public interface ProcessTaskStrategy {

    <T extends BaseInfoDto> void execute(CompleteProcessDto<T> completeProcessDto);
}
