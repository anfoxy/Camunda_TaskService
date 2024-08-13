package com.example.task_service.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "base_task")
@Getter
@Setter
@ToString
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
    private Long processStatus;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private String email;

    @NotNull
    private String description;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private List<TaskUserEntity> tasks;
}