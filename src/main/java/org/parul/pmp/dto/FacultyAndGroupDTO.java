package org.parul.pmp.dto;

import java.util.ArrayList;

public class FacultyAndGroupDTO
{
    private long facultyId;
    private ArrayList<Long> groupid;


    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    public ArrayList<Long> getGroupid() {
        return groupid;
    }

    public void setGroupid(ArrayList<Long> groupid) {
        this.groupid = groupid;
    }
}
