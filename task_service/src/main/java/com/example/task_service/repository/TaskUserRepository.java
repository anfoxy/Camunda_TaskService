package com.example.task_service.repository;

import com.example.task_service.entity.TaskUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUserEntity, Long> {

    @Query("SELECT b FROM TaskUserEntity b WHERE b.parent.id = :parent")
    List<TaskUserEntity> findByParentId(@Param("parent") Long parent);
}