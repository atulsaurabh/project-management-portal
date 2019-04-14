package org.parul.pmp.dto;

public class ReportDto {
    private long srno;
    private long groupno;
    private String studentName;

    public long getSrno() {
        return srno;
    }

    public void setSrno(long srno) {
        this.srno = srno;
    }

    public long getGroupno() {
        return groupno;
    }

    public void setGroupno(long groupno) {
        this.groupno = groupno;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
