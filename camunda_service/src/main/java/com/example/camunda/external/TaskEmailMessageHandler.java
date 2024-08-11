package com.example.camunda.external;

import com.example.camunda.constant.ExecuteTaskType;
import com.example.camunda.constant.ServiceTaskType;
import com.example.camunda.service.task.ExecuteTasksService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@RequiredArgsConstructor
public class TaskEmailMessageHandler {

   private final ExecuteTasksService executeTasksService;
    @Bean
    @ExternalTaskSubscription(ServiceTaskType.SEND_MESSAGE)
    public ExternalTaskHandler sendMessageHandler() {
        return (externalTask, externalTaskService) -> {
            String processInstanceId = externalTask.getProcessInstanceId();
            externalTaskService.complete(externalTask);
            executeTasksService.executeTask(externalTask);
            Logger.getLogger("sendMessageTopic")
                    .log(Level.INFO, "Task prepared for process instance {0}", new Object[]{processInstanceId});
        };
    }
}