package com.example.task_service.dto;

import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.entity.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BaseTaskDto extends BaseInfoDto {

    private Long id;

    private UserEntity userId;

    private Long processStatus;

    private LocalDateTime time;

    private String email;

    private String description;

    private String name;

    private List<TaskUserEntity> tasks;
}