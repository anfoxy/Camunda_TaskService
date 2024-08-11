package com.example.camunda.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExecuteTaskType {

    COMPLETE_TIMER("timerComplete"),
    SEND_MESSAGE("sendMessage");

    private final String name;
}
