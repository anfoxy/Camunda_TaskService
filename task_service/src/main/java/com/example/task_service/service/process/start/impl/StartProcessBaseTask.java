package com.example.task_service.service.process.start.impl;

import com.example.task_service.constant.TypeTaskProcess;
import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.BaseTaskDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.service.jpa.BaseTaskService;
import com.example.task_service.service.process.start.StartProcessStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(TypeTaskProcess.CREATE)
@Slf4j
@RequiredArgsConstructor
public class StartProcessBaseTask implements StartProcessStrategy {

    private final BaseTaskService baseTaskService;
    @Override
    @Transactional
    public <T extends BaseInfoDto> Long execute(StartProcessDto<T> startProcessDto) {
        T info = startProcessDto.getInfo();
        return baseTaskService.save((BaseTaskDto) info).getId();
    }

}
