package com.example.task_service.mapper;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.dto.TaskUserDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.entity.TaskUserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskUserEntityMapper {
    TaskUserEntity toEntity(TaskUserDto taskDTO);
    TaskUserDto toDTO(TaskUserEntity taskEntity);
}