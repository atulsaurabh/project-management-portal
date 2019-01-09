package org.parul.pmp.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Credential
{

    private String username;
    private String password;

    private User user;


    private Set<Role> roles=new HashSet<>();


    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "credential_role",
            joinColumns = @JoinColumn(name = "credential"),
            inverseJoinColumns = @JoinColumn(name = "role")
    )
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }





    @OneToOne( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
