package org.parul.pmp.dto;

import org.parul.pmp.entity.Address;

public class StudentProfileDTO {
    private String dob;
    private String gender;
    private Address address;


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
