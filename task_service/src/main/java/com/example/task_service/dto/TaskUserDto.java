package com.example.task_service.dto;

import com.example.task_service.entity.BaseTaskEntity;
import lombok.Data;

@Data
public class TaskUserDto {

    private Long idTask;

    private BaseTaskEntity parent;

    private String description;

    private String name;

    private Long status;
}