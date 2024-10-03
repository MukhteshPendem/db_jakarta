package org.ecommerce.dbmgmt.model;


import jakarta.persistence.*;
import org.ecommerce.dbmgmt.keys.CompositeKey;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "task_manager")
public class TaskImpl implements Task{


    @EmbeddedId
    private CompositeKey compositeKey;


    @Column(name = "task_desc", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Column(name = "due_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate date;



    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public TaskStatus getStatus() {
        return status;
    }


    @Override
    public LocalDate getDueDate() {
        return date;
    }

    @Override
    public TaskPriority getPriority() {
        return priority;
    }

    @Override
    public void setStatus(TaskStatus status) {

        this.status = status;
    }

    @Override
    public void setDueDate(LocalDate dueDate) {

        this.date = dueDate;
    }

    @Override
    public void setPriority(TaskPriority priority) {

        this.priority = priority;
    }

    @Override
    public void setDescription(String description) {

        this.description = description;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskImpl task)) return false;
        if (compositeKey == null || task.compositeKey == null) return false;  // Null check
        return Objects.equals(compositeKey.getId(), task.compositeKey.getId()) &&
                Objects.equals(compositeKey.getTitle(), task.compositeKey.getTitle()) &&
                Objects.equals(description, task.description) &&
                status == task.status &&
                priority == task.priority &&
                Objects.equals(date, task.date);
    }


    @Override
    public int hashCode() {
        return Objects.hash(compositeKey.getId(), compositeKey.getTitle(), description, status, priority, date);
    }

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(CompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    @Override
    public String toString() {
        return "TaskImpl{" +
                "id=" + compositeKey.getId() +
                ", title='" + compositeKey.getTitle() + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", date=" + date +
                '}';


    }
}
