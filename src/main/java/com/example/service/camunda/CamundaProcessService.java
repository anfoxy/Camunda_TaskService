package com.example.service.camunda;

import com.example.constant.CamundaVariables;
import com.example.constant.NameCamundaProcess;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CamundaProcessService {

    private final RuntimeService runtimeService;

    public String start(Long idTask) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(CamundaVariables.START_DATE.getName(), new Date());
        variables.put(CamundaVariables.ID_TASK.getName(), idTask);

        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey(NameCamundaProcess.BASE_TASK_PROCESS.getName(), variables);
        return processInstance.getId();
    }
}
