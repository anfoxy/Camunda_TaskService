package com.example.task_service.dto;

import com.example.task_service.entity.BaseTaskEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class TaskUserDto {

    private Long idTask;

    private BaseTaskEntity parent;

    private String description;

    private String name;

    private Long status;
}