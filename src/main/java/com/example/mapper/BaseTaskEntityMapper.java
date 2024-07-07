package com.example.mapper;

import com.example.dto.BaseTaskDto;
import com.example.entity.BaseTaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseTaskEntityMapper {

    BaseTaskEntity toEntity(BaseTaskDto taskDTO);

    BaseTaskDto toDTO(BaseTaskEntity taskEntity);
}