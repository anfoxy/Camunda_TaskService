package com.example.task_service.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "camunda_task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CamundaTaskEntity extends CommonField {

    @Id
    private String id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_task")
    private BaseTaskEntity task;

    private LocalDateTime completeDt;

    private String nameProcess;
}