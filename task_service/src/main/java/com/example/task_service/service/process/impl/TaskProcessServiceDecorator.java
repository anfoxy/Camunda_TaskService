package com.example.task_service.service.process.impl;

import com.example.task_service.constant.NameCamundaProcess;
import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.CompleteProcessDto;
import com.example.task_service.dto.KafkaMessage;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.kafka.KafkaProducerService;
import com.example.task_service.service.jpa.CamundaTaskService;
import com.example.task_service.service.process.TaskProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskProcessServiceDecorator implements TaskProcessService {

    @Value("${spring.kafka.topic.camundaCreateUserTaskTopic}")
    private String camundaCreateUserTaskTopic;

    @Value("${spring.kafka.topic.camundaCompleteUserTaskTopic}")
    private String camundaCompleteUserTaskTopic;

    private final TaskProcessServiceImpl taskProcessService;
    private final CamundaTaskService camundaTaskService;
    private final KafkaProducerService<KafkaMessage> kafkaProducerService;

    public <T extends BaseInfoDto> Long startProcess(StartProcessDto<T> startProcessDto) {
        Long baseTaskId = taskProcessService.startProcess(startProcessDto);
        kafkaProducerService.send(camundaCreateUserTaskTopic, KafkaMessage
                .builder()
                .idBaseTask(baseTaskId)
                .nameProcess(NameCamundaProcess.BASE_TASK_PROCESS.getName())
                .build());
        return baseTaskId;
    }

    public <T extends BaseInfoDto> void completeUserTask(CompleteProcessDto<T>  completeProcessDto){
        taskProcessService.completeUserTask(completeProcessDto);
        camundaTaskService.completeCamundaTask(completeProcessDto.getUserTaskId());

        kafkaProducerService.send(camundaCompleteUserTaskTopic, KafkaMessage
                .builder()
                .idBaseTask(completeProcessDto.getTaskId())
                .id(completeProcessDto.getUserTaskId())
                .status(completeProcessDto.getNameProcess())
                .nameProcess(NameCamundaProcess.BASE_TASK_PROCESS.getName())
                .build());
    }
}
