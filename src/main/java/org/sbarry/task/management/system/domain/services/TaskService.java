package org.sbarry.task.management.system.domain.services;

import org.sbarry.task.management.system.domain.entities.Task;
import org.sbarry.task.management.system.domain.entities.TaskStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    UUID createTask(Task task);
    UUID updateTask(Task task);
    void deleteTask(UUID taskId);
    Optional<Task> getTask(UUID taskId);
    List<Task> getTasks();
}
