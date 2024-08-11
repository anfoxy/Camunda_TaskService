package com.example.camunda.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceTaskDto {

    private Long idBaseTask;
    private String processName;
}