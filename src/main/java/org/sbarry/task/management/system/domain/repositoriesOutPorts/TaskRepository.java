package org.sbarry.task.management.system.domain.repositoriesOutPorts;

import org.sbarry.task.management.system.domain.entities.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(UUID id);
    List<Task> findAll();
    void delete(UUID id);
}
