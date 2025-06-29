package com.nicky.hexagonalTodo.domain.ports.in;

import com.nicky.hexagonalTodo.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskPortIn {

    Optional<Task> getTaskById(Long taskId);
    List<Task> getAllTasks();
}
