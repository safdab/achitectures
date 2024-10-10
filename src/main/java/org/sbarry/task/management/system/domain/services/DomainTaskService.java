package org.sbarry.task.management.system.domain.services;

import org.sbarry.task.management.system.domain.entities.Task;
import org.sbarry.task.management.system.domain.repositoriesOutPorts.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DomainTaskService implements TaskService {

    private final TaskRepository taskRepository;

    public DomainTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public UUID createTask(Task task) {
        task.setId(UUID.randomUUID());
        return this.taskRepository.save(task).getId();
    }

    @Override
    public UUID updateTask(Task task) {
        Optional<Task> optionalTask = this.taskRepository.findById(task.getId());
        if(optionalTask.isPresent()) {
            Task taskToUpdate = optionalTask.get();
            taskToUpdate.setAssignee(task.getAssignee());
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setStatus(task.getStatus());
            taskToUpdate.setAssigneeEmail(task.getAssigneeEmail());
            taskToUpdate.setDueDate(task.getDueDate());
            taskToUpdate.setTitle(task.getTitle());
            return this.taskRepository.save(taskToUpdate).getId();
        }
        return this.taskRepository.save(task).getId();
    }

    @Override
    public void deleteTask(UUID taskId) {
        this.taskRepository.delete(taskId);
    }

    @Override
    public Optional<Task> getTask(UUID taskId) {
        return this.taskRepository.findById(taskId);
    }

    @Override
    public List<Task> getTasks() {
        return this.taskRepository.findAll();
    }
}
