package com.example.task_service.mapper;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseTaskEntityMapper {

    BaseTaskEntity toEntity(BaseTaskDto taskDTO);

    BaseTaskDto toDTO(BaseTaskEntity taskEntity);
}