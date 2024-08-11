package com.example.task_service.mapper;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.TaskUserDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.entity.TaskUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskUserEntityMapper {
    TaskUserEntity toEntity(TaskUserDto taskDTO);
    TaskUserDto toDTO(TaskUserEntity taskEntity);

    @Mapping(target = "idTask", ignore = true)
    void updateEntityFromDTO(TaskUserDto taskDTO, @MappingTarget TaskUserEntity taskEntity);
}