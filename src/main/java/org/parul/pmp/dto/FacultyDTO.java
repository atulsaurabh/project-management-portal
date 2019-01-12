package org.parul.pmp.dto;

import org.parul.pmp.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class FacultyDTO {

    private int department_id;
    private String faculty_code;
    private String faculty_firstname;
    private String faculty_middlename;
    private String faculty_lastname;
    private String email;
    private String phone;
    private String username;
    private String password;
    /*private List<DepartmentDTO> departmentDTOS = new ArrayList<>();

    public List<DepartmentDTO> getDepartmentDTOS() {
        return departmentDTOS;
    }

    public void setDepartmentDTOS(List<DepartmentDTO> departmentDTOS) {
        this.departmentDTOS = departmentDTOS;
    }*/

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getFaculty_code() {
        return faculty_code;
    }

    public void setFaculty_code(String faculty_code) {
        this.faculty_code = faculty_code;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
