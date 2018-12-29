package org.parul.pmp.dto;

public class UniversityDTO {

    private int university_code;
    private String university_name;
    private String contact_no;
    private String email;
    private String fax;
    private String website;


    public int getUniversity_code() {
        return university_code;
    }

    public void setUniversity_code(int university_code) {
        this.university_code = university_code;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
