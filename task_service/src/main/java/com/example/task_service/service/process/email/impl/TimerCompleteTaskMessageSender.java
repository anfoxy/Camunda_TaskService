package com.example.task_service.service.process.email.impl;

import com.example.task_service.constant.TaskCompleteType;
import com.example.task_service.constant.TypeTaskProcess;
import com.example.task_service.entity.BaseTaskEntity;
import com.example.task_service.service.process.email.Notification;
import com.example.task_service.service.process.email.TaskComplete;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service(TaskCompleteType.TASK_TIMER)
@Slf4j
public class TimerCompleteTaskMessageSender implements TaskComplete {

    private final Notification emailMessageSender;
    @Override
    public void complete(BaseTaskEntity baseTask) {
        log.info("Отправка сообщения об окончании времени на выполнение задачи: " + baseTask.getId());
        emailMessageSender.send("Закончилось время выполнения задачи " + baseTask.getName());
    }
}