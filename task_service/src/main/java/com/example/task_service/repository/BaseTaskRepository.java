package com.example.task_service.repository;

import com.example.task_service.entity.BaseTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseTaskRepository extends JpaRepository<BaseTaskEntity, Long> {

    @Query("SELECT b FROM BaseTaskEntity b WHERE b.userId.id = :userId")
    List<BaseTaskEntity> findByUserId(@Param("userId") Long userId);
}