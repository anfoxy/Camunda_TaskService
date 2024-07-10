package com.example.task_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "task_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskUserEntity extends CommonField{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_task;

    @ManyToOne
    @JoinColumn(name = "base_task")
    private BaseTaskEntity baseTask;

    @ManyToOne
    @JoinColumn(name = "id_parent")
    private TaskUserEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<TaskUserEntity> tasks;

    private String description;

    private String name;

    private Long status;

    private Long type;
}