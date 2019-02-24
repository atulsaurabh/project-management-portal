package org.parul.pmp.dto;

import org.parul.pmp.entity.Faculty;
import org.parul.pmp.entity.Student;

import java.time.Instant;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class GroupDTO {
    private long groupId;
    private Year year;
    private long department_id;
    private String groupName;
    private long faculty_id;
    private String enrollment;


    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    public long getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(long faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }


}
