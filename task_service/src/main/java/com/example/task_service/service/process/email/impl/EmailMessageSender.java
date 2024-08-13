package com.example.task_service.service.process.email.impl;

import com.example.task_service.service.process.email.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailMessageSender implements Notification {
    @Override
    public void send(String message) {

        log.info("Отправка сообщения на почту: " + message);
    }
}
