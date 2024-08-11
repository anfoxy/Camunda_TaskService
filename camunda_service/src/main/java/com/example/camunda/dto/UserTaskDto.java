package com.example.camunda.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTaskDto {

    private String id;

    private Long task;

    private String nameProcess;
}