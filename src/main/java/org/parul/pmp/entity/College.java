package org.parul.pmp.entity;


import javax.persistence.*;

@Entity
@Table(name = "College")
public class College {
   // private int college_id;
    private String college_code;
    private String college_name;
    private String contact_no;
    private String email;
    private String website;
    private String fax;
    private Address address;
    @Transient
    private int universityid;

    public int getUniversityid() {
        return universityid;
    }

    public void setUniversityid(int universityid) {
        this.universityid = universityid;
    }
  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
 //  @Column(name = "College_Id")
   // public int getCollege_id() {
       // return college_id;
   // }

   // public void setCollege_id(int college_id) {
       // this.college_id = college_id;
   // }

    @Id
    public String getCollege_code() {
        return college_code;
    }

    public void setCollege_code(String college_code) {
        this.college_code = college_code;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
