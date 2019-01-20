package org.parul.pmp.dto;



public class DepartmentDTO
{
    private String department_code;
    private String department_name;
    private long college_id;
    private long deptid;

    public String getDepartment_code() {
        return department_code;
    }

    public void setDepartment_code(String department_code) {
        this.department_code = department_code;
    }

    public long getDeptid() {
        return deptid;
    }

    public void setDeptid(long deptid) {
        this.deptid = deptid;
    }

      public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public long getCollege_id() {
        return college_id;
    }

    public void setCollege_id(long college_id) {
        this.college_id = college_id;
    }


}
