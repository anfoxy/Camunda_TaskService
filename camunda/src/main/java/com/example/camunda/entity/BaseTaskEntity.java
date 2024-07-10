package com.example.camunda.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @OneToOne
    @JoinColumn(name = "id_task")
    private TaskUserEntity task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    private String username;

    private Long status;

    private LocalDateTime time;

    private String email;

}