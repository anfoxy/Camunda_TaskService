package com.example.task_service.repository;

import com.example.task_service.entity.CamundaTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CamundaTaskRepository extends JpaRepository<CamundaTaskEntity, Long> {


   @Query("SELECT ct FROM CamundaTaskEntity ct " +
           "JOIN FETCH ct.task t " +
           "WHERE t.id = :baseTaskId " +
           "AND ct.completeDt IS NULL " +
           "ORDER BY ct.createDt ASC")
   Optional<CamundaTaskEntity> findFirstByTaskIdAndCompleteDtIsNullOrderByCreateDtAsc(@Param("baseTaskId") Long baseTaskId);
}