package com.example.task_service.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommandType {

    COMPLETE_TIMER("completeTimer"),
    SEND_MESSAGE("sendMessage");

    private final String name;
}
