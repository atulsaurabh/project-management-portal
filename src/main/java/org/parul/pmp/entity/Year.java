package org.parul.pmp.entity;

import javax.persistence.Entity;


public class Year
{
    private long yearid;
    private int yearNumber;

    public long getYearid() {
        return yearid;
    }

    public void setYearid(long yearid) {
        this.yearid = yearid;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }
}
