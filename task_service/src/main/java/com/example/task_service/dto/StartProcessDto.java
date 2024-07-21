package com.example.task_service.dto;

import com.example.task_service.entity.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StartProcessDto {

    private UserEntity userId;

    private Long ProcessStatus;

    private LocalDateTime time;

    private String email;

    private String description;

    private String name;
}