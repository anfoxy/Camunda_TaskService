package com.example.task_service.dto;

import com.example.task_service.entity.BaseTaskEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class CompleteUserTaskDto {

    private Long taskId;

    private String nameProcess;
}
