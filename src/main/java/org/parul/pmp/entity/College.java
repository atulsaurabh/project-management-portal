package org.parul.pmp.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "College")
public class College {
    private long college_id;
    private String collegeCode;
    private String college_name;
    private String contact_no;
    private String email;
    private String website;
    private String fax;
    private Address address;
    private University university;
    private Set<Department>departments = new HashSet<>();
    private LocalDateTime dateOfRegistration;
    private LocalDateTime dateOfModification;

    private User collegeAdmin;

    @OneToOne(mappedBy = "college",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    public User getCollegeAdmin() {
        return collegeAdmin;
    }

    public void setCollegeAdmin(User collegeAdmin) {
        this.collegeAdmin = collegeAdmin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCollege_id() {
        return college_id;
    }

    public void setCollege_id(long college_id) {
        this.college_id = college_id;
    }

    public String getCollegeCode() {
        return collegeCode;
    }
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    public String getCollege_name() {
        return college_name;
    }
    public void setCollege_name(String college_name) {
        this.college_name = college_name;
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

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() { return fax; }
    public void setFax(String fax) {this.fax = fax;}


    @OneToOne(optional = true)
    @JoinColumn(name = "addressid")
    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL)
    public Set<Department> getDepartments() { return departments; }

    public void setDepartments(Set<Department> departments) { this.departments = departments; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    public University getUniversity() { return university; }

    public void setUniversity(University university) { this.university = university; }

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) { this.dateOfRegistration = dateOfRegistration; }

    public LocalDateTime getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(LocalDateTime dateOfModification) { this.dateOfModification = dateOfModification; }
}
