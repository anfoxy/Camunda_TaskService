package com.example.task_service.dto;

import lombok.Data;

@Data
public class CompleteProcessDto<T extends BaseInfoDto> {

    private T info;

    private Long taskId;

    private String userTaskId;

    private String nameProcess;
}
