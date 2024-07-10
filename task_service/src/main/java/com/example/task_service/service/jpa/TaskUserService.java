package com.example.task_service.service.jpa;

import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.repository.TaskUserRepository;
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