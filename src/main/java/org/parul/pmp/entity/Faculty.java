package org.parul.pmp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Faculty")
public class Faculty extends User {
    private String id;
    private String faculty_id;
    private String faculty_firstname;
    private String faculty_middlename;
    private String faculty_lastname;
    private String email;
    private String phone;
    private Department department;
    private String education;
    private String skill;
    private String Published_papers;
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFaculty_firstname() {
        return faculty_firstname;
    }

    public void setFaculty_firstname(String faculty_firstname) {
        this.faculty_firstname = faculty_firstname;
    }

    public String getFaculty_middlename() {
        return faculty_middlename;
    }

    public void setFaculty_middlename(String faculty_middlename) {
        this.faculty_middlename = faculty_middlename;
    }

    public String getFaculty_lastname() {
        return faculty_lastname;
    }

    public void setFaculty_lastname(String faculty_lastname) {
        this.faculty_lastname = faculty_lastname;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPublished_papers() {
        return Published_papers;
    }

    public void setPublished_papers(String published_papers) {
        Published_papers = published_papers;
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
