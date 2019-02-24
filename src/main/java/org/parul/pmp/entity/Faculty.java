package org.parul.pmp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Faculty")
public class Faculty extends User{

    private Long facultyCode;
    private String facultyFirstname;
    private String facultyMiddlename;
    private String facultyLastname;
    private String email;
    private String phone;
    private Department department;
    private String education;
    private String skill;
    private String publishedPapers;
    private Address address;
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;
    private boolean isHod;

    @Column(unique = true)
    public Long getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(Long facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getFacultyFirstname() {
        return facultyFirstname;
    }

    public void setFacultyFirstname(String facultyFirstname) {
        this.facultyFirstname = facultyFirstname;
    }

    public String getFacultyMiddlename() {
        return facultyMiddlename;
    }

    public void setFacultyMiddlename(String facultyMiddlename) {
        this.facultyMiddlename = facultyMiddlename;
    }

    public String getFacultyLastname() { return facultyLastname; }

    public void setFacultyLastname(String facultyLastname) {
        this.facultyLastname = facultyLastname;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

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

    public String getPublishedPapers() {
        return publishedPapers;
    }

    public void setPublishedPapers(String publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) { this.dateOfRegistration = dateOfRegistration; }

    public LocalDateTime getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(LocalDateTime dateOfModification) { this.dateOfModification = dateOfModification; }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "addressid")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isHod() { return isHod; }

    public void setHod(boolean hod) { isHod = hod; }
}
