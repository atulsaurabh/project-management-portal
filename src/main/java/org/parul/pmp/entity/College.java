package org.parul.pmp.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "College")
public class College {
    private long college_id;
    private String college_code;
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

    @OneToOne(mappedBy = "college",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
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

    @NotNull(message = "clg code cannot be null")
    public String getCollege_code() {
        return college_code;
    }
    public void setCollege_code(String college_code) {
        this.college_code = college_code;
    }

    @NotNull(message = "clg name cannot be null")
    public String getCollege_name() {
        return college_name;
    }
    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    @NotNull
    @Size(min = 10, max = 10)
    @Positive
    public String getContact_no() {
        return contact_no;
    }
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    @NotNull
    @Email(message = "email should be valid")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "website cannot be null")
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() { return fax; }
    public void setFax(String fax) {this.fax = fax;}

    @NotNull(message = "address cannot be null")
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "addressid")
    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    @NotNull
    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL)
    public Set<Department> getDepartments() { return departments; }

    public void setDepartments(Set<Department> departments) { this.departments = departments; }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    public University getUniversity() { return university; }

    public void setUniversity(University university) { this.university = university; }

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
