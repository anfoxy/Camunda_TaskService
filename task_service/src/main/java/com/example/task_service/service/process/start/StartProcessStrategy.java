package com.example.task_service.service.process.start;

import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.StartProcessDto;

import java.util.Map;

public interface StartProcessStrategy {

    <T extends BaseInfoDto> Map<String,Object> execute(StartProcessDto<T> startProcessDto);

}
