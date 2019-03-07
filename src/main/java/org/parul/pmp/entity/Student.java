package org.parul.pmp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
public class Student extends User{

    private String firstname;
    private String middlename;
    private String lastname;
    private String dob;
    private Long enrollment;
    //private University university_id;
   // private College college_id;
    private String sem;
    private String email;
    private String gender;
    private String mobile_no;
    private Department department;
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;
    private GroupDetails projectGroup;
    private boolean isCordinator;
    private boolean isGroupMember;

    public boolean isCordinator() {
        return isCordinator;
    }

    public void setCordinator(boolean cordinator) {
        isCordinator = cordinator;
    }

    public boolean isGroupMember() {
        return isGroupMember;
    }

    public void setGroupMember(boolean groupMember) {
        isGroupMember = groupMember;
    }

    //@OneToOne(mappedBy = "members",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    public GroupDetails getProjectGroup() {
        return projectGroup;
    }

    public void setProjectGroup(GroupDetails projectGroup) {
        this.projectGroup = projectGroup;
    }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Column(unique = true)
    public Long getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Long enrollment) {
        this.enrollment = enrollment;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
}


