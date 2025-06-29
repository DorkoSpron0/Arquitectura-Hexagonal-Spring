package com.nicky.hexagonalTodo.domain.ports.in;

public interface DeleteTaskPortIn {

    boolean deleteTask(Long taskId);
}
