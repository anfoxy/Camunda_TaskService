package com.example.camunda.repository;

import com.example.camunda.entity.BaseTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTaskRepository extends JpaRepository<BaseTaskEntity, Long> {

}