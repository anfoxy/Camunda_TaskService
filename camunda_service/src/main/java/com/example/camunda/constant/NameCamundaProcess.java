package com.example.camunda.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NameCamundaProcess {

    BASE_TASK_PROCESS("simpleProcesss");

    private final String name;
}
