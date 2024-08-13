package com.example.task_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "camunda_task")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CamundaTaskEntity extends CommonField {

    @Id
    private String id;

    @Column(name = "id_tasks", nullable = false)
    private Long task;

    private LocalDateTime completeDt;

    private String nameProcess;
}