package com.example.task_service.service.jpa;

import com.example.task_service.entity.CamundaTaskEntity;
import com.example.task_service.repository.CamundaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CamundaTaskService {

    private final CamundaTaskRepository camundaTaskRepository;

    public void completeCamundaTask(Long idBaseTask) {
        CamundaTaskEntity camundaTaskEntity = camundaTaskRepository
                .findFirstByTaskIdAndCompleteDtIsNullOrderByCreateDtAsc(idBaseTask)
                .orElseThrow(() -> new RuntimeException("CamundaTaskEntity не найдено по idBaseTask = " + idBaseTask));;
        camundaTaskEntity.setCompleteDt(LocalDateTime.now());
        camundaTaskRepository.save(camundaTaskEntity);
    }
}