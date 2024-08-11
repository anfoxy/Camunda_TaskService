package com.example.task_service.service.process.camunda;

import com.example.task_service.dto.UserTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.entity.CamundaTaskEntity;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.jpa.CamundaTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrepareTaskService {

    private final CamundaTaskService camundaTaskService;
    private final BaseTaskService baseTaskService;
    public void prepareTask(UserTaskDto userTaskDto) {
        log.info("Получено сообщение на подготовку задачи: " + userTaskDto.toString());
        BaseTaskEntity baseTaskEntity = baseTaskService.getById(userTaskDto.getTask());
       CamundaTaskEntity camundaTaskEntity = camundaTaskService.save(CamundaTaskEntity
                .builder()
                .id(userTaskDto.getId())
                .task(baseTaskEntity.getId())
                .nameProcess(userTaskDto.getNameProcess())
                .build());
        log.info("Получено сообщение на подготовку задачи: " + camundaTaskEntity.toString());
    }
}
