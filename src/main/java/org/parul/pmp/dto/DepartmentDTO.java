package org.parul.pmp.dto;

public class DepartmentDTO
{
    private String departmentCode;
    private String department_name;
    private String college_id;
    private long deptid;

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public long getDeptid() {
        return deptid;
    }

    public void setDeptid(long deptid) {
        this.deptid = deptid;
    }

    public String getDepartmentCode() { return departmentCode; }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartment_name() { return department_name; }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

}
