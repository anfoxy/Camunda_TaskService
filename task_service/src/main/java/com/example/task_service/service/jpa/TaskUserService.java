package com.example.task_service.service.jpa;

import com.example.task_service.dto.TaskUserDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.exception.TaskServiceNotFoundException;
import com.example.task_service.mapper.BaseTaskEntityMapper;
import com.example.task_service.mapper.TaskUserEntityMapper;
import com.example.task_service.repository.TaskUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskUserService {

    private final TaskUserRepository taskUserRepository;

    private final TaskUserEntityMapper taskUserEntityMapper;

    public TaskUserEntity saveTask(TaskUserDto task) {
        TaskUserEntity taskUserEntity = taskUserEntityMapper.toEntity(task);
        return taskUserRepository.save(taskUserEntity);
    }

    public TaskUserEntity getById(Long id){
        return Optional.of(taskUserRepository.getReferenceById(id))
                .orElseThrow(() -> new TaskServiceNotFoundException("По id = %d нет записи".formatted(id)));
    }

    public TaskUserEntity addTask(Long baseTaskId, Long taskId, TaskUserDto taskDto) {
        TaskUserEntity newTaskUserEntity = taskUserEntityMapper.toEntity(taskDto);
        //необходима проверка статуса базового дела
        TaskUserEntity parent = getById(taskId);
        newTaskUserEntity.setParent(parent);
        return taskUserRepository.save(newTaskUserEntity);
    }

    public TaskUserEntity update(Long taskId, TaskUserDto taskDto) {
        TaskUserEntity newTaskUserEntity = taskUserEntityMapper.toEntity(taskDto);
        return taskUserRepository.save(newTaskUserEntity);
    }
}