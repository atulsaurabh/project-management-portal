package org.parul.pmp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "University")
public class University {

    private int university_code;
    private String university_name;
    private String contact_no;
    private String email;
    private String fax;
    private String website;
    private Address address;
    private Set<College>colleges=new HashSet<>();

    @Id
    //@Column(name = "university_id" )
    public int getUniversity_code() { return university_code; }

    public void setUniversity_code(int university_code) { this.university_code = university_code; }

    public String getUniversity_name() { return university_name; }

    public void setUniversity_name(String university_name) { this.university_name = university_name; }

    public String getContact_no() { return contact_no; }

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

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "addressid")
    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }


    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    public Set<College> getColleges() { return colleges; }

    public void setColleges(Set<College> colleges) { this.colleges = colleges; }
}

