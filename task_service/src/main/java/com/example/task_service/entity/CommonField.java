package com.example.task_service.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class CommonField {

    @NotNull
    private LocalDateTime createDt;

    @NotNull
    private LocalDateTime updateDt;

    @NotNull
    private String statusField;

}
