package com.nicky.hexagonalTodo.application.usecases;

import com.nicky.hexagonalTodo.domain.ports.in.DeleteTaskPortIn;
import com.nicky.hexagonalTodo.domain.ports.out.TaskRepositoryPortOut;

public class DeleteTaskImpl implements DeleteTaskPortIn {

    private final TaskRepositoryPortOut taskRepository;

    public DeleteTaskImpl(TaskRepositoryPortOut taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public boolean deleteTask(Long taskId) {
        return taskRepository.deleteById(taskId);
    }
}
