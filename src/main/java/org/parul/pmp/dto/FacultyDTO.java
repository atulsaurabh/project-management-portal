package org.parul.pmp.dto;

public class FacultyDTO {

    private long department_id;

    private Long facultyCode;
    private String facultyFirstname;
    private String facultyMiddlename;
    private String facultyLastname;
    private String email;
    private String phone;
    private String username;
    private String password;
    private Boolean isHod;
    /*private List<DepartmentDTO> departmentDTOS = new ArrayList<>();

    public List<DepartmentDTO> getDepartmentDTOS() {
        return departmentDTOS;
    }

    public void setDepartmentDTOS(List<DepartmentDTO> departmentDTOS) {
        this.departmentDTOS = departmentDTOS;
    }*/

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

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

    public String getFacultyLastname() {
        return facultyLastname;
    }

    public void setFacultyLastname(String facultyLastname) {
        this.facultyLastname = facultyLastname;
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

    public Boolean getHod() { return isHod; }

    public void setHod(Boolean hod) { isHod = hod; }
}
