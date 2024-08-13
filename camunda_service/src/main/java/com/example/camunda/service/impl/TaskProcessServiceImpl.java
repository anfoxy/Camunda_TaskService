package com.example.camunda.service.impl;

import com.example.camunda.constant.CamundaVariables;
import com.example.camunda.dto.KafkaMessage;
import com.example.camunda.service.TaskProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.Job;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskProcessServiceImpl implements TaskProcessService {

    private final TaskService taskService;
    private final RuntimeService runtimeService;
    private final ManagementService managementService;

    public String startProcess(KafkaMessage message) {
        Map<String, Object> variables = message.getVariables();
        variables.put(CamundaVariables.START_DATE.getName(), new Date());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(message.getNameProcess(), variables);
        log.info("Создан процесс: " + processInstance.getId());
        return processInstance.getId();
    }

    public void completeUserTask(KafkaMessage message) {
        log.info("Завершение задачи: " + message.getId());
        taskService.complete(message.getId());
    }

    public void updateTime(KafkaMessage message) {
        String processInstanceId = message.getId();
        String newTimerDuration = message.getVariables().get("time").toString();

        runtimeService.setVariable(processInstanceId, "time", newTimerDuration);

        List<Job> jobs = managementService.createJobQuery()
                .processInstanceId(processInstanceId)
                .activityId("BoundaryTimer")
                .list();

        for (Job job : jobs) {
            managementService.deleteJob(job.getId());
        }
    }
}
