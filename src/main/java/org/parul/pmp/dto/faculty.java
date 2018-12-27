package org.parul.pmp.dto;

import javax.persistence.*;

@Entity
@Table(name = "Faculty")
public class faculty {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    //@NotEmpty
    private String name;
    private String email;
    private String phone;
    private String college;
    private String university;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "id")

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() { return college; }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
