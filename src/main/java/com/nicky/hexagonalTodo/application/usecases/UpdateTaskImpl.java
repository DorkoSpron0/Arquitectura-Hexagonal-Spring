package com.nicky.hexagonalTodo.application.usecases;

import com.nicky.hexagonalTodo.domain.models.Task;
import com.nicky.hexagonalTodo.domain.ports.in.UpdateTaskPortIn;
import com.nicky.hexagonalTodo.domain.ports.out.TaskRepositoryPortOut;

import java.util.Optional;

public class UpdateTaskImpl implements UpdateTaskPortIn {

    private final TaskRepositoryPortOut taskRepository;

    public UpdateTaskImpl(TaskRepositoryPortOut taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> updateTask(Long taskId, Task task) {
        return taskRepository.update(task);
    }
}
