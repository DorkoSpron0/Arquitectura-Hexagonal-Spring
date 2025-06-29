package com.nicky.hexagonalTodo.domain.ports.in;

import com.nicky.hexagonalTodo.domain.models.Task;

public interface CreateTaskPortIn {

    Task createTask(Task task);
}
