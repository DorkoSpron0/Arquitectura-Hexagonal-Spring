package com.nicky.hexagonalTodo.application.usecases;

import com.nicky.hexagonalTodo.domain.models.AdditionalTaskInfo;
import com.nicky.hexagonalTodo.domain.ports.in.GetAdditionalTaskInfoPortIn;
import com.nicky.hexagonalTodo.domain.ports.out.ExternalServicePortOut;

public class GetAdditionalTaskInfoImpl implements GetAdditionalTaskInfoPortIn {

    private final ExternalServicePortOut externalService;

    public GetAdditionalTaskInfoImpl(ExternalServicePortOut externalService) {
        this.externalService = externalService;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalService.getAdditionalTaskInfo(id);
    }
}
