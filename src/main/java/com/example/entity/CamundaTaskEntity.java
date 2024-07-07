package com.example.entity;


import jakarta.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "id_task")
    private BaseTaskEntity task;

    private LocalDateTime complete;

}