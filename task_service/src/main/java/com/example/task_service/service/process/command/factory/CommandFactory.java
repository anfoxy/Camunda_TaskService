package com.example.task_service.service.process.command.factory;

import com.example.task_service.service.process.command.Command;

public interface CommandFactory<T,R extends Command> {
    String getType();
    R getCommand(T obj);
}