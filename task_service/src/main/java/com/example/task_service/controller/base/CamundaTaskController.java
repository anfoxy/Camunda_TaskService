package com.example.task_service.controller.base;

import com.example.task_service.entity.CamundaTaskEntity;
import com.example.task_service.service.jpa.CamundaTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/camunda-tasks")
public class CamundaTaskController {

    @Autowired
    private CamundaTaskService camundaTaskService;

    @GetMapping("/task/{baseTaskId}")
    public List<CamundaTaskEntity> getBaseTaskEntityByUserId(@PathVariable Long baseTaskId) {
        return camundaTaskService.getByBaseTask(baseTaskId);
    }


}