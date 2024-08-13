package com.example.task_service.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TaskCompleteType {
    
    public static final String TASK_TIMER = "CompleteTimer";
    public static final String TASK_CANCEL = "Cancel";
    public static final String TASK_COMPLETE = "Complete";
}
