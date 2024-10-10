package org.sbarry.task.management.system.infrastructure.postgresql;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.sbarry.task.management.system.domain.entities.Task;
import org.sbarry.task.management.system.domain.entities.TaskStatus;
import jakarta.persistence.Entity;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    private UUID id;
    private String title;
    private String description;
    private String assignee;
    private String assigneeEmail;
    private String assigneePhone;
    private String dueDate;
    private TaskStatus status;

    public TaskEntity(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.assignee = task.getAssignee();
        this.assigneeEmail = task.getAssigneeEmail();
        this.assigneePhone = task.getAssigneePhone();
        this.dueDate = task.getDueDate();
        this.status = task.getStatus();
    }

    public Task toTask() {
        return new Task(this.id, this.title, this.description, this.assignee, this.assigneeEmail, this.assigneePhone, this.dueDate, this.status);
    }

}
