package com.example.task_service.service.process.start;

import com.example.task_service.dto.BaseInfoDto;
import com.example.task_service.dto.StartProcessDto;

public interface StartProcessStrategy {

    <T extends BaseInfoDto> Long execute(StartProcessDto<T> startProcessDto);

}
