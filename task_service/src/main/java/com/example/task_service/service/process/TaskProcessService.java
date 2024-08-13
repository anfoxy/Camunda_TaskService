package com.example.task_service.service.process;

import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.CompleteProcessDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.entity.BaseTaskEntity;

import java.util.Map;

public interface TaskProcessService {

    <T extends BaseInfoDto> Map<String,Object> startProcess(StartProcessDto<T> startProcessDto);

    <T extends BaseInfoDto> void completeUserTask(CompleteProcessDto<T>  completeProcessDto);
}
