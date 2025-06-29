package com.nicky.hexagonalTodo.application.usecases;

import com.nicky.hexagonalTodo.domain.models.Task;
import com.nicky.hexagonalTodo.domain.ports.in.CreateTaskPortIn;
import com.nicky.hexagonalTodo.domain.ports.out.TaskRepositoryPortOut;

public class CreateTaskImpl implements CreateTaskPortIn {

    private final TaskRepositoryPortOut taskRepository;

    public CreateTaskImpl(TaskRepositoryPortOut taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}

