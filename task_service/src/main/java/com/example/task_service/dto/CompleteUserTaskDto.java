package com.example.task_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CompleteUserTaskDto {

    private String nameProcess;

    private Long idTask;

}
