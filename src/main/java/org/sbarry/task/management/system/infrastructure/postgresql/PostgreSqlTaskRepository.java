package org.sbarry.task.management.system.infrastructure.postgresql;

import org.sbarry.task.management.system.domain.entities.Task;
import org.sbarry.task.management.system.domain.repositoriesOutPorts.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PostgreSqlTaskRepository implements TaskRepository {


    private final SpringDataPostgresTaskRepository postgresTaskRepository;
    @Autowired
    public PostgreSqlTaskRepository(SpringDataPostgresTaskRepository postgresTaskRepository) {
        this.postgresTaskRepository = postgresTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = new TaskEntity(task);
        this.postgresTaskRepository.save(taskEntity);
        return taskEntity.toTask();
    }

    @Override
    public Optional<Task> findById(UUID id) {
        Optional<TaskEntity> taskEntity = this.postgresTaskRepository.findById(id);
        return taskEntity.map(TaskEntity::toTask);
    }

    @Override
    public List<Task> findAll() {
        return this.postgresTaskRepository.findAll()
                .stream()
                .map(TaskEntity::toTask).toList();
    }

    @Override
    public void delete(UUID id) {
        this.postgresTaskRepository.deleteById(id);
    }
}
