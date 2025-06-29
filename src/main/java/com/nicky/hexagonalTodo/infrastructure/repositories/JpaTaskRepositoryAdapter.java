package com.nicky.hexagonalTodo.infrastructure.repositories;

import com.nicky.hexagonalTodo.domain.models.Task;
import com.nicky.hexagonalTodo.domain.ports.out.TaskRepositoryPortOut;
import com.nicky.hexagonalTodo.infrastructure.entities.TaskEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class JpaTaskRepositoryAdapter implements TaskRepositoryPortOut {

    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomain(task);
        return jpaTaskRepository.save(taskEntity).toDomain();
    }

    @Override
    public Optional<Task> findById(Long taskId) {
        return jpaTaskRepository.findById(taskId).map(TaskEntity::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll()
                .stream()
                .map(TaskEntity::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public Optional<Task> update(Task task) {

        if(jpaTaskRepository.existsById(task.getId())){
            TaskEntity taskEntity = TaskEntity.fromDomain(task);
            TaskEntity updateTaskEntity = jpaTaskRepository.save(taskEntity);

            return Optional.of(updateTaskEntity.toDomain());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long taskId) {
        if(jpaTaskRepository.existsById(taskId)){
            jpaTaskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }
}
