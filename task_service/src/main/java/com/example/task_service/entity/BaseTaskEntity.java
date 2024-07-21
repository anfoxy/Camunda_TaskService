package com.example.task_service.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "base_task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseTaskEntity extends CommonField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @NotNull
    private Long ProcessStatus;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private String email;

    @OneToOne
    @JoinColumn(name = "idTask")
    private TaskUserEntity taskUser;
}