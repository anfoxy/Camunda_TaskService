package com.example.task_service.mapper;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BaseTaskEntityMapper {
    BaseTaskEntity toEntity(BaseTaskDto taskDTO);
    BaseTaskDto toDTO(BaseTaskEntity taskEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    void updateEntityFromDTO(BaseTaskDto taskDTO, @MappingTarget BaseTaskEntity taskEntity);
}