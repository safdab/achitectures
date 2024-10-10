package org.sbarry.task.management.system.application.rest;

import org.sbarry.task.management.system.domain.entities.Task;
import org.sbarry.task.management.system.domain.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/tasks")
public class RestController {

    private final TaskService taskService;
    private Logger logger = Logger.getLogger(RestController.class.getName());

    @Autowired
    public RestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody Task task) throws Exception {
        logger.info("Creating task: " + task);
        if(task.getId() != null) {
            return ResponseEntity.badRequest().body("Id parameter cannot be non null");
        }
        this.taskService.createTask(task);
        return ResponseEntity
                .status(201)
                .body(task.getId().toString());
    }

    @GetMapping(value="/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTask(@PathVariable final UUID taskId) {
        Optional<Task> task = taskService.getTask(taskId);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(this.taskService.getTasks());
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UUID> update(@RequestBody final Task task) {
        return ResponseEntity.ok(this.taskService.updateTask(task));
    }

    @DeleteMapping(value = "/{taskId}")
    public ResponseEntity<Void> delete(@PathVariable final UUID taskId) {
        this.taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

}
