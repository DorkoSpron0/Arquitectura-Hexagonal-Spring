package com.nicky.hexagonalTodo.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ExceptionHandlerCustom implements WebMvcConfigurer {
    @Autowired
    private ErrorHandlingInterceptor errorHandlingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(errorHandlingInterceptor);
    }
}

