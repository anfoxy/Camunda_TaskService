package com.example.service.process.complete.impl;

import com.example.constant.StatusTask;
import com.example.dto.CompleteUserTaskDto;
import com.example.entity.BaseTaskEntity;
import com.example.service.jpa.BaseTaskService;
import com.example.service.process.complete.ProcessTaskStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CancelBaseTask  implements ProcessTaskStrategy {

    private final BaseTaskService baseTaskService;

    @Override
    public void execute(CompleteUserTaskDto completeUserTaskDto) {
        Optional<BaseTaskEntity> baseTaskEntity = baseTaskService.getById(completeUserTaskDto.getIdTask());
        baseTaskEntity.ifPresent(task -> {
            task.setStatus(StatusTask.CANCEL.getId());
            baseTaskService.saveBaseTask(task);
        });

        //Ошибку
    }
}
