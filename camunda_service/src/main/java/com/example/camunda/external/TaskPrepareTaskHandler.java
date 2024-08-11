package com.example.camunda.external;

import com.example.camunda.constant.ServiceTaskType;
import com.example.camunda.dto.UserTaskDto;
import com.example.camunda.kafka.KafkaProducerService;
import com.example.camunda.service.task.ExecuteTasksService;
import com.example.camunda.service.task.PrepareTasksService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@RequiredArgsConstructor
public class TaskPrepareTaskHandler {

    private final PrepareTasksService prepareTasksService;

    @Bean
    @ExternalTaskSubscription(ServiceTaskType.PREPARE_TASK)
    public ExternalTaskHandler prepareTaskHandler() {
        return (externalTask, externalTaskService) -> {
            String processInstanceId = externalTask.getProcessInstanceId();
            externalTaskService.complete(externalTask);
            prepareTasksService.prepareTask(externalTask);
            Logger.getLogger("prepareTaskTopic")
                    .log(Level.INFO, "Task prepared for process instance {0}", new Object[]{processInstanceId});

        };
    }

}