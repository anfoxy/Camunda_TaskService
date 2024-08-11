package com.example.task_service.service.process.complete.impl;

import com.example.task_service.constant.StatusTask;
import com.example.task_service.constant.TypeTaskProcess;
import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.CompleteProcessDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.process.complete.ProcessTaskStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(TypeTaskProcess.COMPLETE)
@Slf4j
@RequiredArgsConstructor
public class CompleteBaseTask implements ProcessTaskStrategy {

    private final BaseTaskService baseTaskService;

    @Override
    @Transactional
    public <T extends BaseInfoDto> void execute(CompleteProcessDto<T> completeProcessDto) {
        log.info("Меняем статус задачи %d на %s".formatted(completeProcessDto.getTaskId(), StatusTask.COMPLETE.getName()));
        BaseTaskEntity baseTaskEntity = baseTaskService.getById(completeProcessDto.getTaskId());
        baseTaskEntity.setProcessStatus(StatusTask.COMPLETE.getId());
        baseTaskService.save(baseTaskEntity);
    }

}
