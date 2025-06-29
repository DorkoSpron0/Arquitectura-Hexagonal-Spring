package com.nicky.hexagonalTodo.domain.ports.out;

import com.nicky.hexagonalTodo.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPortOut {

    Task save(Task task);
    Optional<Task> findById(Long taskId);
    List<Task> findAll();
    Optional<Task> update(Task task);
    boolean deleteById(Long taskId);
}
