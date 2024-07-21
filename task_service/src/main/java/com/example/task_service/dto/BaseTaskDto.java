package com.example.task_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseTaskDto {

    private Long id;

    private TaskUserDto task;

    private String username; //+

    private Long status;

    private LocalDateTime time; //+

    private String email; //+

}