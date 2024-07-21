package com.example.task_service.dto;

import com.example.task_service.entity.CommonField;
import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.entity.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BaseTaskDto {

    private Long id;

    private UserDto userId;

    private Long ProcessStatus;

    private LocalDateTime CompleteTime;

    private String email;

    private TaskUserDto taskUser;
}