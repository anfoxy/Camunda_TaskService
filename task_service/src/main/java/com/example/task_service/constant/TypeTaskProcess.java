package com.example.task_service.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TypeTaskProcess {

    public static final String CREATE = "CreateBaseTask";
    public static final String START = "StartBaseTask";
    public static final String CANCEL = "CancelBaseTask";
    public static final String COMPLETE = "CompleteBaseTask";
}
