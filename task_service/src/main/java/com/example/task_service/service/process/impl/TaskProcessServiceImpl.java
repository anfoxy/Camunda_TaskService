package com.example.task_service.service.process.impl;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.exception.TaskServiceNotFoundException;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.jpa.TaskUserService;
import com.example.task_service.service.process.TaskProcessService;
import com.example.task_service.service.process.complete.ProcessTaskStrategy;
import com.example.task_service.dto.CompleteUserTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskProcessServiceImpl implements TaskProcessService {

    private final Map<String, ProcessTaskStrategy> processTaskStrategyMap;

    private final BaseTaskService baseTaskService;
    private final TaskUserService taskUserService;

    public BaseTaskEntity startProcess(BaseTaskDto baseTaskDto) {
        TaskUserEntity taskUserEntity = taskUserService.saveTask(baseTaskDto.getTaskUser());
        return baseTaskService.saveBaseTask(baseTaskDto, taskUserEntity);
    }

    public void completeUserTask(CompleteUserTaskDto completeUserTaskDto) {
        Optional.ofNullable(processTaskStrategyMap.get(completeUserTaskDto.getNameProcess()))
                .orElseThrow(() -> new TaskServiceNotFoundException("Неизвестное имя процесса: " + completeUserTaskDto.getNameProcess()))
                .execute(completeUserTaskDto);

    }
}
