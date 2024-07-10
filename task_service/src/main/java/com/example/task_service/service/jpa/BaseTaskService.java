package com.example.task_service.service.jpa;

import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.repository.BaseTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseTaskService {

    private final BaseTaskRepository baseTaskRepository;

    public BaseTaskEntity saveBaseTask(BaseTaskEntity baseTask) {
        return baseTaskRepository.save(baseTask);
    }

    public List<BaseTaskEntity> getAllBaseTasks() {
        return baseTaskRepository.findAll();
    }

    public Optional<BaseTaskEntity> getById(Long id){
        return Optional.of(baseTaskRepository.getById(id));
    }
}