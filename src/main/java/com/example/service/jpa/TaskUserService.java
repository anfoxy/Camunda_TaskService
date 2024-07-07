package com.example.service.jpa;

import com.example.entity.TaskUserEntity;
import com.example.repository.TaskUserRepository;
import lombok.AllArgsConstructor;
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