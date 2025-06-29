package com.nicky.hexagonalTodo.domain.ports.in;

import com.nicky.hexagonalTodo.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoPortIn {

    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
