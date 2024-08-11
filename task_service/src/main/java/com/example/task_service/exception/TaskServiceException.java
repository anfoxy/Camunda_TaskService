package com.example.task_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class TaskServiceException extends RuntimeException {

    public TaskServiceException() {
        super("Failed to create");
    }

    public TaskServiceException(String message) {
        super(message);
    }

}