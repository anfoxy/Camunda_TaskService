package com.example.service.impl;

import com.example.dto.BaseTaskDto;
import com.example.dto.CompleteUserTaskDto;
import com.example.service.TaskProcessService;
import com.example.service.camunda.CamundaProcessService;
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

    public String startProcess(BaseTaskDto baseTaskDto) {
        Long idTask = createDraftBaseTask.createDraftTask(baseTaskDto);
        return camundaProcessService.start(idTask);
    }

    public void completeUserTask(CompleteUserTaskDto completeUserTaskDto) {
        processTaskStrategyMap.get(completeUserTaskDto.getNameProcess()).execute(completeUserTaskDto);
        //отправка в камунду завершение
    }
}
