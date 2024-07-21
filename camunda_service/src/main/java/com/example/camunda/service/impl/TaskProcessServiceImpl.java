package com.example.camunda.service.impl;


import com.example.camunda.constant.CamundaVariables;
import com.example.camunda.model.KafkaMessage;
import com.example.camunda.service.TaskProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskProcessServiceImpl implements TaskProcessService {

    private final TaskService taskService;
    private final RuntimeService runtimeService;

    public String startProcess(KafkaMessage message) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(CamundaVariables.START_DATE.getName(), new Date());
        variables.put(CamundaVariables.ID_BASE_TASK.getName(), message.getIdBaseTask());
        variables.put(CamundaVariables.USER.getName(), message.getUser());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(message.getNameProcess(), variables);
        log.info("Создан процесс: " + processInstance.getId());
        return processInstance.getId();
    }

    public void completeUserTask(KafkaMessage message) {
        String processInstanceId = taskService.createTaskQuery()
                .processInstanceId(message.getId().toString())
                .active().singleResult().getId();
        log.info("Для процесса: " + message.getId() + ", завершение задачи: " + processInstanceId);
        taskService.complete(processInstanceId);
    }
}
