package com.example.task_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class TaskUserDto {

    private Long idTask;

    private TaskUserDto parent;

    private List<TaskUserDto> tasks;

    private String description;

    private String name;

    private Long status;
}