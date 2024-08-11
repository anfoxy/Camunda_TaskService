package com.example.task_service.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
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


    @PreUpdate
    public void prePersistOrUpdate() {
        this.updateDt = LocalDateTime.now();
        this.statusField = "U";
    }

    @PrePersist
    public void prePersist() {
        this.createDt = LocalDateTime.now();
        this.updateDt = LocalDateTime.now();
        this.statusField = "I";
    }
}
