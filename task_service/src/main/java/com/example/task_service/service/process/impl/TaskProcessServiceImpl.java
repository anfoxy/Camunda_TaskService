package com.example.task_service.service.process.impl;

import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.StartProcessDto;
import com.example.task_service.exception.TaskServiceException;
import com.example.task_service.service.process.TaskProcessService;
import com.example.task_service.service.process.complete.ProcessTaskStrategy;
import com.example.task_service.dto.CompleteProcessDto;
import com.example.task_service.service.process.start.StartProcessStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskProcessServiceImpl implements TaskProcessService {

    private final Map<String, ProcessTaskStrategy> processTaskStrategyMap;

    private final Map<String, StartProcessStrategy> startTaskStrategyMap;

    @Transactional
    public <T extends BaseInfoDto> Map<String,Object> startProcess(StartProcessDto<T> startProcessDto) {
        return Optional.ofNullable(startTaskStrategyMap.get(startProcessDto.getNameProcess()))
                .orElseThrow(() -> new TaskServiceException("Неизвестное имя процесса: " + startProcessDto.getNameProcess()))
                .execute(startProcessDto);
    }

    public <T extends BaseInfoDto> void completeUserTask(CompleteProcessDto<T>  completeProcessDto) {
        Optional.ofNullable(processTaskStrategyMap.get(completeProcessDto.getNameProcess()))
                .orElseThrow(() -> new TaskServiceException("Неизвестное имя процесса: " + completeProcessDto.getNameProcess()))
                .execute(completeProcessDto);
    }
}
