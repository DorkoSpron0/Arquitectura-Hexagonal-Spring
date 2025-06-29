package com.nicky.hexagonalTodo.domain.ports.out;

import com.nicky.hexagonalTodo.domain.models.AdditionalTaskInfo;

public interface ExternalServicePortOut {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
