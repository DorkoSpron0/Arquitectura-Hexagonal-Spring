package com.nicky.hexagonalTodo.application.usecases;

import com.nicky.hexagonalTodo.domain.models.Task;
import com.nicky.hexagonalTodo.domain.ports.in.RetrieveTaskPortIn;
import com.nicky.hexagonalTodo.domain.ports.out.TaskRepositoryPortOut;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskImpl implements RetrieveTaskPortIn {

    private final TaskRepositoryPortOut taskRepository;

    public RetrieveTaskImpl(TaskRepositoryPortOut taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
