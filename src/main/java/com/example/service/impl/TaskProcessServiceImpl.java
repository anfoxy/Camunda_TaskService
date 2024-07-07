package com.example.service.impl;

import com.example.dto.BaseTaskDto;
import com.example.dto.CompleteUserTaskDto;
import com.example.entity.BaseTaskEntity;
import com.example.entity.CamundaTaskEntity;
import com.example.service.TaskProcessService;
import com.example.service.camunda.CamundaProcessService;
import com.example.service.jpa.CamundaTaskService;
import com.example.service.process.start.CreateDraftBaseTask;
import com.example.service.process.complete.ProcessTaskStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskProcessServiceImpl implements TaskProcessService {

    private final Map<String, ProcessTaskStrategy> processTaskStrategyMap;

    private final CreateDraftBaseTask createDraftBaseTask;
    private final CamundaProcessService camundaProcessService;
    private final CamundaTaskService camundaTaskService;

    public String startProcess(BaseTaskDto baseTaskDto) {
        BaseTaskEntity baseTask = createDraftBaseTask.createDraftTask(baseTaskDto);
        //Потом переместить в отдельный модуль и заменить на отправку сообщения в топик
        String camundaTaskId = camundaProcessService.start(baseTask.getId());

        CamundaTaskEntity camundaTaskEntity = CamundaTaskEntity
                .builder()
                .task(baseTask)
                .id(camundaTaskId)
                .build();

        camundaTaskService.saveCamundaTask(camundaTaskEntity);
        return camundaTaskId;
    }

    public void completeUserTask(CompleteUserTaskDto completeUserTaskDto) {
        processTaskStrategyMap.get(completeUserTaskDto.getNameProcess()).execute(completeUserTaskDto);
        camundaProcessService.complete(completeUserTaskDto.getIdTask());
        camundaTaskService.completeCamundaTask(completeUserTaskDto.getIdTask());
        //отправка в камунду завершение
    }
}
