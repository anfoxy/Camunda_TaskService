package com.example.task_service.service.process.start.impl;

import com.example.task_service.constant.TypeTaskProcess;
import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.process.start.StartProcessStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service(TypeTaskProcess.CREATE)
@Slf4j
@RequiredArgsConstructor
public class StartProcessBaseTask implements StartProcessStrategy {

    private final BaseTaskService baseTaskService;
    @Override
    @Transactional
    public <T extends BaseInfoDto> Map<String,Object> execute(StartProcessDto<T> startProcessDto) {
        T info = startProcessDto.getInfo();
        BaseTaskEntity baseTaskEntity = baseTaskService.save((BaseTaskDto) info);

        Map<String,Object> variables = new HashMap<>();
        variables.put("idBaseTask",baseTaskEntity.getId());
        variables.put("time",baseTaskEntity.getTime().toString());

        return variables;
    }

}
