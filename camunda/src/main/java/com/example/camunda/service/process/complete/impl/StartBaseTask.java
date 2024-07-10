package com.example.camunda.service.process.complete.impl;

import com.example.camunda.constant.StatusTask;
import com.example.camunda.dto.CompleteUserTaskDto;
import com.example.camunda.entity.BaseTaskEntity;
import com.example.camunda.service.jpa.BaseTaskService;
import com.example.camunda.service.process.complete.ProcessTaskStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StartBaseTask implements ProcessTaskStrategy {

    private final BaseTaskService baseTaskService;

    @Override
    public void execute(CompleteUserTaskDto completeUserTaskDto) {
        Optional<BaseTaskEntity> baseTaskEntity = baseTaskService.getById(completeUserTaskDto.getIdTask());
        baseTaskEntity.ifPresent(task -> {
            if(Objects.isNull(task.getTask())) {
                //Ошибку
                //переделать на маппу
            }
            task.setStatus(StatusTask.RUN.getId());
            baseTaskService.saveBaseTask(task);
            //сохранение в бд задач
        });

        //Ошибку
    }
}
