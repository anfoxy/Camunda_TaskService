package com.example.camunda.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProcessController {

    private final RuntimeService runtimeService;

    public ProcessController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/start-process")
    public ResponseEntity<String> startProcess() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("startDate", new Date());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("simpleProcess", variables);

        return ResponseEntity.ok(processInstance.getId());
    }
}