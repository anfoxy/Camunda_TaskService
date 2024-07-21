package com.example.task_service.service.jpa;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.exception.TaskServiceNotFoundException;
import com.example.task_service.mapper.BaseTaskEntityMapper;
import com.example.task_service.repository.BaseTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseTaskService {

    private final BaseTaskRepository baseTaskRepository;

    private final BaseTaskEntityMapper baseTaskEntityMapper;


    public BaseTaskEntity saveBaseTask(BaseTaskDto baseTask, TaskUserEntity taskUserEntity) {
        BaseTaskEntity baseTaskEntity = baseTaskEntityMapper.toEntity(baseTask);
        baseTaskEntity.setTaskUser(taskUserEntity);
        return baseTaskRepository.save(baseTaskEntity);
    }

    public BaseTaskEntity update(BaseTaskEntity baseTask) {
        return baseTaskRepository.save(baseTask);
    }

    public BaseTaskEntity getById(Long id){
        return Optional.of(baseTaskRepository.getReferenceById(id))
                .orElseThrow(() -> new TaskServiceNotFoundException("По id = %d нет записи".formatted(id)));
    }
}