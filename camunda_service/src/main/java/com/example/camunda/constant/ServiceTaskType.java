package com.example.camunda.constant;

import lombok.Getter;

@Getter
public class ServiceTaskType {

    public static final String SEND_MESSAGE = "sendMessageTopic";
    public static final String PREPARE_TASK = "prepareTaskTopic";
    public static final String TIMER_COMPLETION = "timerCompletionTopic";
}
