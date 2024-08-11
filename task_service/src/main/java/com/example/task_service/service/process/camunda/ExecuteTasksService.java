package com.example.task_service.service.process.camunda;

import com.example.task_service.dto.ServiceTaskDto;
import com.example.task_service.service.process.command.CommandFactoryRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExecuteTasksService {

    private final CommandFactoryRegistry commandFactoryRegistry;
    public void executeTask(ServiceTaskDto serviceTaskDto) {
        log.info("Получено сообщение на выполнение задачи: " + serviceTaskDto.toString());
        commandFactoryRegistry.getCommand(serviceTaskDto.getProcessName(),serviceTaskDto).execute();


    }
}
