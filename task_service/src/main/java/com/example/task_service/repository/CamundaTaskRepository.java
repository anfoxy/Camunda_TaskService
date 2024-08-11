package com.example.task_service.repository;

import com.example.task_service.entity.CamundaTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CamundaTaskRepository extends JpaRepository<CamundaTaskEntity, String> {

   @Query("SELECT ct FROM CamundaTaskEntity ct " +
           "WHERE ct.task = :baseTaskId ")
   List<CamundaTaskEntity> getByBaseTask(@Param("baseTaskId") Long baseTaskId);
   @Query("SELECT ct FROM CamundaTaskEntity ct " +
           "WHERE ct.task = :baseTaskId " +
           "AND ct.completeDt IS NULL " +
           "ORDER BY ct.createDt ASC")
   Optional<CamundaTaskEntity> findFirstByTaskIdAndCompleteDtIsNullOrderByCreateDtAsc(@Param("baseTaskId") Long baseTaskId);
}