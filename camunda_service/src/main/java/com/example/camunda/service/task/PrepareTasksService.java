package com.example.camunda.service.task;

import com.example.camunda.constant.CamundaVariables;
import com.example.camunda.dto.UserTaskDto;
import com.example.camunda.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PrepareTasksService {

    @Value("${spring.kafka.topic.prepareTasksTopic}")
    private String prepareTasksTopic;

    private final TaskService taskService;

    private final KafkaProducerService<UserTaskDto> kafkaProducerService;

    public void prepareTask(ExternalTask externalTask) {
        String processInstanceId = externalTask.getProcessInstanceId();

        Integer idBaseTaskInteger = externalTask.getVariable(CamundaVariables.ID_BASE_TASK.getName());
        Long idBaseTask = idBaseTaskInteger != null ? idBaseTaskInteger.longValue() : null;

        String id = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .active().singleResult().getId();

        kafkaProducerService.send(prepareTasksTopic, UserTaskDto
                .builder()
                .id(id)
                .nameProcess(externalTask.getActivityId())
                .task(idBaseTask)
                .build());
        Logger.getLogger(prepareTasksTopic)
                .log(Level.INFO, "Task create {0}", new Object[]{id});
    }
}
