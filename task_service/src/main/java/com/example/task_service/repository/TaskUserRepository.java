package com.example.task_service.repository;

import com.example.task_service.entity.TaskUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUserEntity, Long> {

}