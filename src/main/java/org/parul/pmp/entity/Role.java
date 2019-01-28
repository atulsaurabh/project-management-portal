package org.parul.pmp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    private int roleid;
    private String name;


    private Set<Credential> credential=new HashSet<>();


    @ManyToMany(mappedBy = "roles")
    public Set<Credential> getCredential() {
        return credential;
    }

    public void setCredential(Set<Credential> credential) {
        this.credential = credential;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
