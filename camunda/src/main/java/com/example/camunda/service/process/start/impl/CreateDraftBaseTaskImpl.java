package com.example.camunda.service.process.start.impl;

import com.example.camunda.dto.BaseTaskDto;
import com.example.camunda.entity.BaseTaskEntity;
import com.example.camunda.mapper.BaseTaskEntityMapper;
import com.example.camunda.service.jpa.BaseTaskService;
import com.example.camunda.service.process.start.CreateDraftBaseTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDraftBaseTaskImpl implements CreateDraftBaseTask {

   private final BaseTaskService baseTaskService;
   private final BaseTaskEntityMapper baseTaskEntityMapper;

   public BaseTaskEntity createDraftTask(BaseTaskDto baseTaskDto) {
      BaseTaskEntity baseTaskEntity = baseTaskEntityMapper.toEntity(baseTaskDto);
      baseTaskEntity = baseTaskService.saveBaseTask(baseTaskEntity);

      //сохраняем в таблицу с задачами

      return baseTaskEntity;
   }

}
