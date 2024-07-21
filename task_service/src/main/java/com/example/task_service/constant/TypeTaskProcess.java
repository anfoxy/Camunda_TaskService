package com.example.task_service.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TypeTaskProcess {

    public static final String START = "CancelBaseTask";
    public static final String CANCEL = "CompleteBaseTask";
    public static final String COMPLETE = "StartBaseTask";
}
