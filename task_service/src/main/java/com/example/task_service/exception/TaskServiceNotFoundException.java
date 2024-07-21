package com.example.task_service.exception;

public class TaskServiceNotFoundException extends RuntimeException {
    public TaskServiceNotFoundException(String message) {
        super(message);
    }
}