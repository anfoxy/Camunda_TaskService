package com.example.camunda.repository;

import com.example.camunda.entity.BaseTaskEntity;
import com.example.camunda.entity.CamundaTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CamundaTaskRepository extends JpaRepository<CamundaTaskEntity, Long> {

   Optional<CamundaTaskEntity> getByTask(BaseTaskEntity task);
}