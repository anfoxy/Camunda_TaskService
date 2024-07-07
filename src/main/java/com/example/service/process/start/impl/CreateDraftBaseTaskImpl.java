package com.example.service.process.start.impl;

import com.example.dto.BaseTaskDto;
import com.example.entity.BaseTaskEntity;
import com.example.mapper.BaseTaskEntityMapper;
import com.example.service.jpa.BaseTaskService;
import com.example.service.process.start.CreateDraftBaseTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDraftBaseTaskImpl implements CreateDraftBaseTask {

   private final BaseTaskService baseTaskService;
   private final BaseTaskEntityMapper baseTaskEntityMapper;

   public Long createDraftTask(BaseTaskDto baseTaskDto) {
      BaseTaskEntity baseTaskEntity = baseTaskEntityMapper.toEntity(baseTaskDto);
      baseTaskEntity = baseTaskService.saveBaseTask(baseTaskEntity);

      //сохраняем в таблицу с задачами

      return baseTaskEntity.getId();
   }

}
