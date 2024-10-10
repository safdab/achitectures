package org.sbarry.task.management.system.domain.entities;


import java.util.Objects;
import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private String description;
    private String assignee;
    private String assigneeEmail;
    private String assigneePhone;
    private String dueDate;
    private TaskStatus status;

    public Task() {}

    public Task(String title, String description, TaskStatus status) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Task(String title, String description, String assignee, String assigneeEmail, String assigneePhone, String dueDate, TaskStatus status) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.assigneeEmail = assigneeEmail;
        this.assigneePhone = assigneePhone;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task(UUID id, String title, String description, String assignee, String assigneeEmail, String assigneePhone, String dueDate, TaskStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.assigneeEmail = assigneeEmail;
        this.assigneePhone = assigneePhone;
        this.dueDate = dueDate;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public void setAssigneeEmail(String assigneeEmail) {
        this.assigneeEmail = assigneeEmail;
    }

    public String getAssigneePhone() {
        return assigneePhone;
    }

    public void setAssigneePhone(String assigneePhone) {
        this.assigneePhone = assigneePhone;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(assignee, task.assignee) &&
                Objects.equals(assigneeEmail, task.assigneeEmail) &&
                Objects.equals(assigneePhone, task.assigneePhone) &&
                Objects.equals(dueDate, task.dueDate) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, assignee, assigneeEmail, assigneePhone, dueDate, status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignee='" + assignee + '\'' +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", assigneePhone='" + assigneePhone + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", status=" + status +
                '}';
    }
}
