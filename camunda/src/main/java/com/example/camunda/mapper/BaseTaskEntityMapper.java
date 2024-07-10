package com.example.camunda.mapper;

import com.example.camunda.dto.BaseTaskDto;
import com.example.camunda.entity.BaseTaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseTaskEntityMapper {

    BaseTaskEntity toEntity(BaseTaskDto taskDTO);

    BaseTaskDto toDTO(BaseTaskEntity taskEntity);
}