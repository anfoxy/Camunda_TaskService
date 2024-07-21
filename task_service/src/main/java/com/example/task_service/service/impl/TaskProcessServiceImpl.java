package com.example.task_service.service.impl;

import com.example.task_service.service.TaskProcessService;
import com.example.task_service.service.process.complete.ProcessTaskStrategy;
import com.example.task_service.service.process.start.CreateDraftBaseTask;
import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.CompleteUserTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.jpa.CamundaTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskProcessServiceImpl implements TaskProcessService {

    private final Map<String, ProcessTaskStrategy> processTaskStrategyMap;

    private final CreateDraftBaseTask createDraftBaseTask;
    private final CamundaTaskService camundaTaskService;

    public String startProcess(BaseTaskDto baseTaskDto) {
        BaseTaskEntity baseTask = createDraftBaseTask.createDraftTask(baseTaskDto);
        //Потом переместить в отдельный модуль и заменить на отправку сообщения в топик

   /*     CamundaTaskEntity camundaTaskEntity = CamundaTaskEntity
                .builder()
                .task(baseTask)
                .id(camundaTaskId)
                .build();

        camundaTaskService.saveCamundaTask(camundaTaskEntity);*/
        return null;
    }

    public void completeUserTask(CompleteUserTaskDto completeUserTaskDto) {
        processTaskStrategyMap.get(completeUserTaskDto.getNameProcess()).execute(completeUserTaskDto);
        //camundaTaskService.completeCamundaTask(completeUserTaskDto.getIdTask());
        //отправка в камунду завершение
    }
}
