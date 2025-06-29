package com.nicky.hexagonalTodo.infrastructure.repositories;

import com.nicky.hexagonalTodo.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
