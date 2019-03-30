package org.parul.pmp.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "University")
public class University {

    private long university_id;
    private String university_code;
    private String university_name;
    private String contact_no;
    private String email;
    private String fax;
    private String website;
    private Address address;
    private Set<College>colleges=new HashSet<>();
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;

    private User universityAdmin;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(long university_id) {
        this.university_id = university_id;
    }

    @OneToOne(mappedBy = "university",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    public User getUniversityAdmin() {
        return universityAdmin;
    }

    public void setUniversityAdmin(User universityAdmin) {
        this.universityAdmin = universityAdmin;
    }

    //@Column(name = "university_id" )
    @Column(unique = true)
    public String getUniversity_code() { return university_code; }

    public void setUniversity_code(String university_code) { this.university_code = university_code; }

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

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public LocalDateTime getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(LocalDateTime dateOfModification) {
        this.dateOfModification = dateOfModification;
    }
}

