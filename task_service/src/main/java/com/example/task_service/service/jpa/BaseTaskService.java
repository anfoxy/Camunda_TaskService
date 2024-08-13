package com.example.task_service.service.jpa;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.exception.TaskServiceException;
import com.example.task_service.mapper.BaseTaskEntityMapper;
import com.example.task_service.repository.BaseTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseTaskService {

    private final BaseTaskRepository baseTaskRepository;

    private final BaseTaskEntityMapper baseTaskEntityMapper;

    @Transactional
    public BaseTaskEntity save(BaseTaskDto baseTask) {
        BaseTaskEntity baseTaskEntity = baseTaskEntityMapper.toEntity(baseTask);
        return baseTaskRepository.save(baseTaskEntity);
    }

    @Transactional
    public BaseTaskEntity save(BaseTaskEntity baseTask) {
        return baseTaskRepository.save(baseTask);
    }

    @Transactional
    public BaseTaskEntity updateAndCheck(BaseTaskDto baseTaskDto) {
        if (Objects.isNull(baseTaskDto.getId())) {
            throw new TaskServiceException("Неизвестен id задачи для ее обновления");
        }

        BaseTaskEntity oldTask = baseTaskRepository.findById(baseTaskDto.getId())
                .orElseThrow(() -> new TaskServiceException("По id = %d нет записи".formatted(baseTaskDto.getId())));

        baseTaskEntityMapper.updateEntityFromDTO(baseTaskDto, oldTask);

        return baseTaskRepository.save(oldTask);
    }

    public BaseTaskEntity getById(Long id){
        return baseTaskRepository.findById(id)
                .orElseThrow(() -> new TaskServiceException("По id = %d нет записи".formatted(id)));
    }

    public List<BaseTaskEntity> getByUserId(Long userId) {
        return Optional.of(baseTaskRepository.findByUserId(userId))
                .orElseThrow(() -> new TaskServiceException("По userId = %d нет записи".formatted(userId)));
    }

}