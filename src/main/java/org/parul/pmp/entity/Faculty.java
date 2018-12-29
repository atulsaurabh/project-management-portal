package org.parul.pmp.entity;

import javax.persistence.*;

@Entity
@Table(name = "Faculty")
public class Faculty extends User {
    private String faculty_name;
    private String email;
    private String phone;
    private Department department;


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
    @JoinColumn(name = "departmentid")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
