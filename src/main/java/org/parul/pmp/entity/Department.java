package org.parul.pmp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Department")
public class Department {

    private long department_id;
    private String departmentCode;
    private String department_name;
    private College college;
    private Set<Student>students=new HashSet<>();
    private Set<Faculty>faculties=new HashSet<>();
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;


    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getDepartment_id() { return department_id; }

    public void setDepartment_id(long department_id) { this.department_id = department_id; }

    public String getDepartment_name() { return department_name; }

    public void setDepartment_name(String department_name) { this.department_name = department_name; }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id")
    public College getCollege() { return college; }

    public void setCollege(College college) { this.college = college; }

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Faculty> getFaculties() { return faculties; }

    public void setFaculties(Set<Faculty> faculties) { this.faculties = faculties; }

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
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
