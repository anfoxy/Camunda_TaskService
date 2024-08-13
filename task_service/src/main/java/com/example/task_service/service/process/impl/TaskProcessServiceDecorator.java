package com.example.task_service.service.process.impl;

import com.example.task_service.constant.NameCamundaProcess;
import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.CompleteProcessDto;
import com.example.task_service.dto.KafkaMessage;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.kafka.KafkaProducerService;
import com.example.task_service.service.jpa.CamundaTaskService;
import com.example.task_service.service.process.TaskProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    public <T extends BaseInfoDto> Map<String,Object> startProcess(StartProcessDto<T> startProcessDto) {
        Map<String,Object> variables = taskProcessService.startProcess(startProcessDto);

        kafkaProducerService.send(camundaCreateUserTaskTopic, KafkaMessage
                .builder()
                .variables(variables)
                .nameProcess(NameCamundaProcess.BASE_TASK_PROCESS.getName())
                .build());
        return variables;
    }

    public <T extends BaseInfoDto> void completeUserTask(CompleteProcessDto<T>  completeProcessDto){
        taskProcessService.completeUserTask(completeProcessDto);
        camundaTaskService.completeCamundaTask(completeProcessDto.getUserTaskId());

        Map<String,Object> variables = new HashMap<>();
        variables.put("idBaseTask",completeProcessDto.getTaskId());

        kafkaProducerService.send(camundaCompleteUserTaskTopic, KafkaMessage
                .builder()
                .variables(variables)
                .id(completeProcessDto.getUserTaskId())
                .status(completeProcessDto.getNameProcess())
                .nameProcess(NameCamundaProcess.BASE_TASK_PROCESS.getName())
                .build());
    }
}
