package com.example.task_service.service.process.impl;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.CompleteUserTaskDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.process.TaskProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskProcessServiceDecorator implements TaskProcessService {

    private final TaskProcessServiceImpl taskProcessService;

    public BaseTaskEntity startProcess(BaseTaskDto baseTaskDto) {
        BaseTaskEntity baseTask = taskProcessService.startProcess(baseTaskDto);
        //Отправляем сообщение в топик
        return baseTask;
    }

    public void completeUserTask(CompleteUserTaskDto completeUserTaskDto) {
        taskProcessService.completeUserTask(completeUserTaskDto);
        //camundaTaskService.completeCamundaTask(completeUserTaskDto.getTaskId());
        //Отправляем сообщение в топик (обработать отмену) можно попробовать команду
    }
}
