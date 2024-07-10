package com.example.camunda.service.jpa;

import com.example.camunda.entity.TaskUserEntity;
import com.example.camunda.repository.TaskUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskUserService {

    private final TaskUserRepository taskUserRepository;

    public TaskUserEntity saveTask(TaskUserEntity task) {
        return taskUserRepository.save(task);
    }

    public List<TaskUserEntity> getAllTasks() {
        return taskUserRepository.findAll();
    }

}