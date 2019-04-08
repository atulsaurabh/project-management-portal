package org.parul.pmp.dto;

import org.parul.pmp.entity.Faculty;

public class DepartmentDTO
{

    private String department_code;
    private String department_name;
    private long college_id;
    private long deptid;
    //private Faculty hod;
    //private Faculty projectCoordinator;
    public long getCollege_id() {
        return college_id;
    }

    public void setCollege_id(long college_id) {
        this.college_id = college_id;
    }

    public long getDeptid() {
        return deptid;
    }

    public void setDeptid(long deptid) {
        this.deptid = deptid;
    }

    public String getDepartment_code() { return department_code; }

    public void setDepartment_code(String department_code) {
        this.department_code = department_code;
    }

    public String getDepartment_name() { return department_name; }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    /*public Faculty getHod() {
        return hod;
    }

    public void setHod(Faculty hod) {
        this.hod = hod;
    }

    public Faculty getProjectCoordinator() {
        return projectCoordinator;
    }

    public void setProjectCoordinator(Faculty projectCoordinator) {
        this.projectCoordinator = projectCoordinator;
    }*/
}
