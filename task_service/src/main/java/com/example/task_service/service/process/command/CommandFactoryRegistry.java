package com.example.task_service.service.process.command;

import com.example.task_service.dto.ServiceTaskDto;
import com.example.task_service.exception.TaskServiceException;
import com.example.task_service.service.process.command.factory.CommandFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class CommandFactoryRegistry {

    private final Map<String, CommandFactory<ServiceTaskDto, ? extends Command>> commandFactories = new HashMap<>();

    @Autowired
    public CommandFactoryRegistry(List<CommandFactory<ServiceTaskDto, ? extends Command>> factories) {
        for (CommandFactory<ServiceTaskDto, ? extends Command> factory : factories) {
            commandFactories.put(factory.getType(), factory);
        }
    }

    public Command getCommand(String commandType, ServiceTaskDto kafkaMessage) {
        CommandFactory<ServiceTaskDto, ? extends Command> factory = commandFactories.get(commandType);
        if (factory != null) {
            return factory.getCommand(kafkaMessage);
        }
        throw new TaskServiceException("Не найдена команда типа: " + commandType);
    }
}