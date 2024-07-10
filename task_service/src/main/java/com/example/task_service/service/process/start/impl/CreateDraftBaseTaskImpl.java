package com.example.task_service.service.process.start.impl;

import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.mapper.BaseTaskEntityMapper;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.process.start.CreateDraftBaseTask;
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
