package com.example.camunda.receive;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamundaMessageSender {

    @Autowired
    private RuntimeService runtimeService;

    public void sendTerminateMessage(String processInstanceId) {
        runtimeService.createMessageCorrelation("terminate")
                .processInstanceId(processInstanceId)
                .correlateWithResult();
    }
}