package com.example.task_service.service.process.command;

import com.example.task_service.constant.StatusTask;
import com.example.task_service.dto.ServiceTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.jpa.CamundaTaskService;
import org.springframework.transaction.annotation.Transactional;

public class TimerCompleteCommand implements Command {

    private final ServiceTaskDto kafkaMessage;

    private final BaseTaskService baseTaskService;

    private final CamundaTaskService camundaTaskService;

    public TimerCompleteCommand(ServiceTaskDto kafkaMessage, BaseTaskService  baseTaskService, CamundaTaskService camundaTaskService) {
        this.kafkaMessage = kafkaMessage;
        this.baseTaskService = baseTaskService;
        this.camundaTaskService = camundaTaskService;
    }

    @Override
    @Transactional
    public void execute() {
        BaseTaskEntity baseTaskEntity = baseTaskService.getById(kafkaMessage.getIdBaseTask());
        baseTaskEntity.setProcessStatus(StatusTask.COMPLETE_TIMER.getId());
        baseTaskService.save(baseTaskEntity);
        camundaTaskService.completeCamundaTask(kafkaMessage.getIdBaseTask());
    }
}