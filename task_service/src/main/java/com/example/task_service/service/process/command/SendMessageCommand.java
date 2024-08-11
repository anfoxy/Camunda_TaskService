package com.example.task_service.service.process.command;

import com.example.task_service.constant.StatusTask;
import com.example.task_service.dto.KafkaMessage;
import com.example.task_service.dto.ServiceTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.exception.TaskServiceException;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.process.email.TaskComplete;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public class SendMessageCommand implements Command {

    private final ServiceTaskDto kafkaMessage;

    private final BaseTaskService baseTaskService;

    private final Map<String, TaskComplete> taskCompleteMap;

    public SendMessageCommand(ServiceTaskDto kafkaMessage, Map<String, TaskComplete> taskCompleteMap, BaseTaskService  baseTaskService) {
        this.baseTaskService = baseTaskService;
        this.kafkaMessage = kafkaMessage;
        this.taskCompleteMap = taskCompleteMap;
    }
    @Override
    public void execute() {
        BaseTaskEntity baseTaskEntity = baseTaskService.getById(kafkaMessage.getIdBaseTask());
        StatusTask statusTask = StatusTask.getById(baseTaskEntity.getProcessStatus());

        if (Objects.isNull(statusTask)) {
           throw new TaskServiceException("StatusTask не найден по ProcessStatus = " + baseTaskEntity.getProcessStatus());
        }

        Optional.ofNullable(taskCompleteMap.get(statusTask.getName()))
                .orElseThrow(() -> new TaskServiceException("Неизвестное имя процесса: " + statusTask.getName()))
                .complete(baseTaskEntity);
    }
}