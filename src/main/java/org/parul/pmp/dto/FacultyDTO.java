package org.parul.pmp.dto;

public class FacultyDTO {

    private String faculty_id;
    private String faculty_firstname;
    private String faculty_middlename;
    private String faculty_lastname;
    private String email;
    private String phone;
    private String username;
    private String password;

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
