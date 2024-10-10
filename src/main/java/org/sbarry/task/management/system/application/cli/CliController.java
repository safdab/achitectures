package org.sbarry.task.management.system.application.cli;

import org.sbarry.task.management.system.domain.entities.Task;
import org.sbarry.task.management.system.domain.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CliController {
    private final TaskService taskService;

    @Autowired
    public CliController(TaskService taskService) {
        this.taskService = taskService;
    }
   
    public UUID createTask(Task task) {
        return this.taskService.createTask(task);
    }

   
    public UUID updateTask(Task task) {
        return this.taskService.updateTask(task);
    }

   
    public void deleteTask(UUID taskId) {
        this.taskService.deleteTask(taskId);
    }

   
    public Optional<Task> getTask(UUID taskId) {
        return this.taskService.getTask(taskId);
    }

   
    public List<Task> getTasks() {
        return this.taskService.getTasks();
    }
}
