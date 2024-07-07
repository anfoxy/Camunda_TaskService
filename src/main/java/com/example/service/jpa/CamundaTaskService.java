package com.example.service.jpa;

import com.example.entity.BaseTaskEntity;
import com.example.entity.CamundaTaskEntity;
import com.example.repository.CamundaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CamundaTaskService {

    private final CamundaTaskRepository camundaTaskRepository;

    public CamundaTaskEntity saveCamundaTask(CamundaTaskEntity camundaTaskEntity) {
        return camundaTaskRepository.save(camundaTaskEntity);
    }

    public List<CamundaTaskEntity> getAllCamundaTasks() {
        return camundaTaskRepository.findAll();
    }

    public Optional<CamundaTaskEntity> getById(Long id){
        return Optional.of(camundaTaskRepository.getReferenceById(id));
    }
    public Optional<CamundaTaskEntity> getByTaskId(Long id){
        return camundaTaskRepository.getByTask(BaseTaskEntity.builder().id(id).build());
    }

    public void completeCamundaTask(Long id) {

    }
}