package com.example.task_service.service.process.command.factory.impl;

import com.example.task_service.constant.CommandType;
import com.example.task_service.dto.ServiceTaskDto;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.jpa.CamundaTaskService;
import com.example.task_service.service.process.command.TimerCompleteCommand;
import com.example.task_service.service.process.command.factory.CommandFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TimerCompleteCommandFactory implements CommandFactory<ServiceTaskDto, TimerCompleteCommand> {

    private final BaseTaskService baseTaskService;

    private final CamundaTaskService camundaTaskService;

    @Override
    public String getType() {
        return CommandType.COMPLETE_TIMER.getName();
    }

    @Override
    public TimerCompleteCommand getCommand(ServiceTaskDto kafkaMessage) {
        return new TimerCompleteCommand(kafkaMessage, baseTaskService, camundaTaskService);
    }
}