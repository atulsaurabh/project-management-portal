package org.parul.pmp.entity;

import javax.persistence.*;

@Entity
@Table(name = "Faculty")
public class Faculty extends User {
    private String faculty_name;
    private String email;
    private String phone;
    private Department department;
    private String education;
    private String skill;
    private String Published_papers;


    public String getFaculty_name() { return faculty_name; }

    public void setFaculty_name(String faculty_name) { this.faculty_name = faculty_name; }


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
}
