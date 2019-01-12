package org.parul.pmp.dto;

import org.parul.pmp.entity.Address;

public class FacultyProfileDTO {
    private String education;
    private String skill;
    private String Published_papers;
    private Address address;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPublished_papers() {
        return Published_papers;
    }

    public void setPublished_papers(String published_papers) {
        Published_papers = published_papers;
    }
}
