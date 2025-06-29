package com.nicky.hexagonalTodo.application.services;

import com.nicky.hexagonalTodo.domain.models.AdditionalTaskInfo;
import com.nicky.hexagonalTodo.domain.models.Task;
import com.nicky.hexagonalTodo.domain.ports.in.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// Implements all Ports in
// Reglas de negocio
public class TaskService implements CreateTaskPortIn, DeleteTaskPortIn, GetAdditionalTaskInfoPortIn, RetrieveTaskPortIn, UpdateTaskPortIn {

    private final CreateTaskPortIn createTaskPortIn;
    private final DeleteTaskPortIn deleteTaskPortIn;
    private final GetAdditionalTaskInfoPortIn getAdditionalTaskInfoPortIn;
    private final RetrieveTaskPortIn retrieveTaskPortIn;
    private final UpdateTaskPortIn updateTaskPortIn;

    public TaskService(CreateTaskPortIn createTaskPortIn, DeleteTaskPortIn deleteTaskPortIn, GetAdditionalTaskInfoPortIn getAdditionalTaskInfoPortIn, RetrieveTaskPortIn retrieveTaskPortIn, UpdateTaskPortIn updateTaskPortIn) {
        this.createTaskPortIn = createTaskPortIn;
        this.deleteTaskPortIn = deleteTaskPortIn;
        this.getAdditionalTaskInfoPortIn = getAdditionalTaskInfoPortIn;
        this.retrieveTaskPortIn = retrieveTaskPortIn;
        this.updateTaskPortIn = updateTaskPortIn;
    }

    @Override
    public Task createTask(Task task) {
        task.setCreationDate(LocalDateTime.now());
        task.setCompleted(false);
        return createTaskPortIn.createTask(task);
    }

    @Override
    public boolean deleteTask(Long taskId) {
        return deleteTaskPortIn.deleteTask(taskId);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskInfoPortIn.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTaskById(Long taskId) {
        return retrieveTaskPortIn.getTaskById(taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskPortIn.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long taskId, Task task) {
        return updateTaskPortIn.updateTask(taskId, task);
    }
}
