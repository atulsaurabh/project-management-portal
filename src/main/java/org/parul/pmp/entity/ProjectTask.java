package org.parul.pmp.entity;

import javax.persistence.*;

@Entity
@Table(name = "ProjectTask")
public class ProjectTask {
    private int task_id;
    private String task_name;
    private String task_Description;
    private String task_deadline;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_Description() {
        return task_Description;
    }

    public void setTask_Description(String task_Description) {
        this.task_Description = task_Description;
    }

    public String getTask_deadline() {
        return task_deadline;
    }

    public void setTask_deadline(String task_deadline) {
        this.task_deadline = task_deadline;
    }
}
