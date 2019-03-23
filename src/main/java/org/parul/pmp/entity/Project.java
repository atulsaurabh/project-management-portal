package org.parul.pmp.entity;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Project {
    private long projectId;
    private String title;
    private String description;
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;
    private GroupDetails groupId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
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

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public LocalDateTime getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(LocalDateTime dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    @OneToOne(mappedBy = "projectId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public GroupDetails getGroupId() { return groupId; }

    public void setGroupId(GroupDetails groupId) { this.groupId = groupId; }
}
