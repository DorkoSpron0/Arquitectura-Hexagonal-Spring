package com.nicky.hexagonalTodo.infrastructure.config;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ErrorHandlingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Aquí podrías hacer verificaciones antes de que ocurra un error
        return true; // Continuar con la solicitud
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            System.err.println("Error durante el procesamiento de la solicitud: " + ex.getMessage());
        }
    }
}