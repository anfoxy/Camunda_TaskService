package com.example.task_service.service.process.complete.impl;

import com.example.task_service.constant.TypeTaskProcess;
import com.example.task_service.service.process.complete.ProcessTaskStrategy;
import com.example.task_service.constant.StatusTask;
import com.example.task_service.dto.CompleteUserTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.jpa.BaseTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service(TypeTaskProcess.START)
@Slf4j
@RequiredArgsConstructor
public class StartBaseTask implements ProcessTaskStrategy {

    private final BaseTaskService baseTaskService;

    @Override
    public void execute(CompleteUserTaskDto completeUserTaskDto) {
        log.info("Меняем статус задачи %d на %s".formatted(completeUserTaskDto.getTaskId(), StatusTask.RUN.getName()));
        BaseTaskEntity baseTaskEntity = baseTaskService.getById(completeUserTaskDto.getTaskId());
        baseTaskEntity.setProcessStatus(StatusTask.RUN.getId());
        baseTaskService.update(baseTaskEntity);
    }

}
