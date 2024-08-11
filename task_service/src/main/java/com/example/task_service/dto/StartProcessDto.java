package com.example.task_service.dto;

import lombok.Data;

@Data
public class StartProcessDto <T extends BaseInfoDto> {

    private T info;

    private String nameProcess;
}