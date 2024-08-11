package com.example.task_service.service.jpa;

import com.example.task_service.constant.StatusTask;
import com.example.task_service.dto.TaskUserDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.entity.TaskUserEntity;
import com.example.task_service.exception.TaskServiceException;
import com.example.task_service.mapper.TaskUserEntityMapper;
import com.example.task_service.repository.TaskUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskUserService {

    private final TaskUserRepository taskUserRepository;

    private final TaskUserEntityMapper taskUserEntityMapper;

    private final BaseTaskService baseTaskService;

    public TaskUserEntity getById(Long id){
        return taskUserRepository.findById(id)
                .orElseThrow(() -> new TaskServiceException("По id = %d нет записи".formatted(id)));
    }

    public TaskUserEntity update(TaskUserDto taskDto) {
        TaskUserEntity newTaskUserEntity = taskUserEntityMapper.toEntity(taskDto);
        return taskUserRepository.save(newTaskUserEntity);
    }

    @Transactional
    public TaskUserEntity updateAndCheck(TaskUserDto taskUserDto) {
        if (Objects.isNull(taskUserDto.getIdTask())) {
            throw new TaskServiceException("Неизвестен id задачи для ее обновления");
        }

        TaskUserEntity oldTask = taskUserRepository.findById(taskUserDto.getIdTask())
                .orElseThrow(() -> new TaskServiceException("По id = %d нет записи".formatted(taskUserDto.getIdTask())));

        taskUserEntityMapper.updateEntityFromDTO(taskUserDto, oldTask);

        return taskUserRepository.save(oldTask);
    }
    public TaskUserEntity addTask(Long taskId, TaskUserDto taskDto) {
        BaseTaskEntity baseTaskEntity = baseTaskService.getById(taskId);
        Long statusParent = baseTaskEntity.getProcessStatus();

        if(statusParent.equals(StatusTask.CANCEL.getId()) ||
                statusParent.equals(StatusTask.COMPLETE.getId())){
            throw new TaskServiceException("Статус дела %d не позволяет добавлять задачи".formatted(taskId));
        }

        TaskUserEntity taskUser = TaskUserEntity.builder()
                .description(taskDto.getDescription())
                .name(taskDto.getName())
                .status(taskDto.getStatus())
                .parent(baseTaskEntity)
                .build();

        return  taskUserRepository.save(taskUser);
    }

    public List<TaskUserEntity> getByParentId(Long taskId) {
        return Optional.of(taskUserRepository.findByParentId(taskId))
                .orElseThrow(() -> new TaskServiceException("По taskId = %d нет записи".formatted(taskId)));
    }
}