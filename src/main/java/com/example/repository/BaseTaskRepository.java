package com.example.repository;

import com.example.entity.BaseTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTaskRepository extends JpaRepository<BaseTaskEntity, Long> {

}