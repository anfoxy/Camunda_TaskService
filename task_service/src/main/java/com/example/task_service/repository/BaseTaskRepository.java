package com.example.task_service.repository;

import com.example.task_service.entity.BaseTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTaskRepository extends JpaRepository<BaseTaskEntity, Long> {

}