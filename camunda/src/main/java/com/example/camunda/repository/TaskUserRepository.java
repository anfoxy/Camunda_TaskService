package com.example.camunda.repository;

import com.example.camunda.entity.TaskUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUserEntity, Long> {

}