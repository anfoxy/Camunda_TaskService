package com.example.camunda.service.task;

import com.example.camunda.constant.CamundaVariables;
import com.example.camunda.dto.ServiceTaskDto;
import com.example.camunda.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.task.ExternalTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExecuteTasksService {

    @Value("${spring.kafka.topic.executeTasksTopic}")
    private String executeTasksTopic;

    private final KafkaProducerService<ServiceTaskDto> kafkaProducerService;

    public void executeTask(ExternalTask externalTask) {
        Long idBaseTask = externalTask.getVariable(CamundaVariables.ID_BASE_TASK.getName());
        kafkaProducerService.send(executeTasksTopic, ServiceTaskDto
                .builder()
                .idBaseTask(idBaseTask)
                .processName(externalTask.getActivityId())
                .build());
        log.info("Отправлено сообщение в кафку на отправку уведомления idBaseTask = " + idBaseTask +
                "ActivityId = " +externalTask.getActivityId());
    }
}
