package com.example.task_service.service.process.command.factory.impl;

import com.example.task_service.constant.CommandType;
import com.example.task_service.dto.KafkaMessage;
import com.example.task_service.dto.ServiceTaskDto;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.process.command.SendMessageCommand;
import com.example.task_service.service.process.command.factory.CommandFactory;
import com.example.task_service.service.process.email.TaskComplete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class SendMessageCommandFactory implements CommandFactory<ServiceTaskDto,SendMessageCommand> {

    private final Map<String, TaskComplete> taskCompleteMap;
    private final BaseTaskService baseTaskService;

    @Override
    public String getType() {
        return CommandType.SEND_MESSAGE.getName();
    }

    @Override
    public SendMessageCommand getCommand(ServiceTaskDto kafkaMessage) {
        return new SendMessageCommand(kafkaMessage, taskCompleteMap, baseTaskService);
    }
}