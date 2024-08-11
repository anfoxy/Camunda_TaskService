package com.example.task_service.service.jpa;

import com.example.task_service.constant.StatusTask;
import com.example.task_service.entity.CamundaTaskEntity;
import com.example.task_service.repository.CamundaTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CamundaTaskService {

    private final CamundaTaskRepository camundaTaskRepository;

    public List<CamundaTaskEntity> getByBaseTask(Long idBaseTask) {
       return camundaTaskRepository.getByBaseTask(idBaseTask);
    }

    public void completeCamundaTask(Long idBaseTask) {
        CamundaTaskEntity camundaTaskEntity = camundaTaskRepository
                .findFirstByTaskIdAndCompleteDtIsNullOrderByCreateDtAsc(idBaseTask)
                .orElseThrow(() -> new RuntimeException("CamundaTaskEntity не найдено по idBaseTask = " + idBaseTask));
        log.info("Завершение пользовательской задачи "+ camundaTaskEntity);
        camundaTaskEntity.setCompleteDt(LocalDateTime.now());
        camundaTaskRepository.save(camundaTaskEntity);
    }

    public void completeCamundaTask(String taskId) {
        CamundaTaskEntity camundaTaskEntity = camundaTaskRepository
                .findById(taskId)
                .orElseThrow(() -> new RuntimeException("CamundaTaskEntity не найдено по taskId = " + taskId));
        camundaTaskEntity.setCompleteDt(LocalDateTime.now());
        camundaTaskRepository.save(camundaTaskEntity);
    }

    public CamundaTaskEntity save(CamundaTaskEntity camundaTaskEntity) {
        log.info("Сохранение пользовательской задачи "+ camundaTaskEntity);
        return camundaTaskRepository.save(camundaTaskEntity);
    }
}