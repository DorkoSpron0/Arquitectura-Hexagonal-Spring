package com.nicky.hexagonalTodo.infrastructure.config;

import com.nicky.hexagonalTodo.application.services.TaskService;
import com.nicky.hexagonalTodo.application.usecases.*;
import com.nicky.hexagonalTodo.domain.ports.in.GetAdditionalTaskInfoPortIn;
import com.nicky.hexagonalTodo.domain.ports.out.ExternalServicePortOut;
import com.nicky.hexagonalTodo.domain.ports.out.TaskRepositoryPortOut;
import com.nicky.hexagonalTodo.infrastructure.adapters.ExternalServiceAdapter;
import com.nicky.hexagonalTodo.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // TaskService tiene que ser @Bean porque será inyectado en los Controllers
    @Bean
    public TaskService taskService(TaskRepositoryPortOut taskRepositoryPortOut, GetAdditionalTaskInfoPortIn getAdditionalTaskInfoPortIn){
        return new TaskService(
                new CreateTaskImpl(taskRepositoryPortOut),
                new DeleteTaskImpl(taskRepositoryPortOut),
                getAdditionalTaskInfoPortIn,
                new RetrieveTaskImpl(taskRepositoryPortOut),
                new UpdateTaskImpl(taskRepositoryPortOut)
        );
    }

    @Bean
    public TaskRepositoryPortOut taskRepositoryPortOut(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoPortIn getAdditionalTaskInfoPortIn(ExternalServicePortOut externalServicePortOut){
        return new GetAdditionalTaskInfoImpl(externalServicePortOut);
    }

    @Bean
    public ExternalServicePortOut externalServicePortOut(){
        return new ExternalServiceAdapter();
    }
}
