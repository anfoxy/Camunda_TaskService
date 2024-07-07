package com.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseTaskDto {

    private Long id;

    private TaskUserDto task;

    private UserDto userId;

    private String username;

    private Long status;

    private LocalDateTime time;

    private String email;

}