package com.nicky.hexagonalTodo.domain.ports.in;

import com.nicky.hexagonalTodo.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskPortIn {
    Optional<Task> updateTask(Long taskId, Task task);
}
