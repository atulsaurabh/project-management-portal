package org.parul.pmp.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class GroupDetails {
    private long groupId;
    private int year;
    private String groupName;
    private Department department;
    private Faculty mentor;
    private Student cordinator;
    private Set<Student>members = new HashSet<>();
    private Instant dateOfGroupCreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Instant getDateOfGroupCreation() {
        return dateOfGroupCreation;
    }

    public void setDateOfGroupCreation(Instant dateOfGroupCreation) {
        this.dateOfGroupCreation = dateOfGroupCreation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    //@OneToOne(mappedBy = "groupDetails",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_code")
    public Faculty getMentor() {
        return mentor;
    }

    public void setMentor(Faculty mentor) {
        this.mentor = mentor;
    }

    @OneToOne(mappedBy = "projectGroup",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    public Student getCordinator() {
        return cordinator;
    }


    public void setCordinator(Student cordinator) {
        this.cordinator = cordinator;
    }

    @OneToMany(mappedBy = "projectGroup",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<Student> getMembers() {
        return members;
    }

    public void setMembers(Set<Student> members) {
        this.members = members;
    }

}
