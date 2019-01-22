package org.parul.pmp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Student")
public class Student extends User {

    private String firstname;
    private String middlename;
    private String lastname;
    private String dob;
    private String enrollment_no;
    //private University university_id;
   // private College college_id;
    private String sem;
    private String email;
    private String gender;
    private String mobile_no;
    private Department department_id;
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

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

    public String getEnrollment_no() {
        return enrollment_no;
    }

    public void setEnrollment_no(String enrollment_no) {
        this.enrollment_no = enrollment_no;
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
        return department_id;
    }

    public void setDepartment(Department department) {
        this.department_id = department;
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


