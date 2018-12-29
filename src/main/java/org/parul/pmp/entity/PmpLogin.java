package org.parul.pmp.entity;

import javax.persistence.*;

@Entity
@Table(name = "memLogin")
public class PmpLogin {
    private String login_id;
    private String mem_role;
    private String username;
    private String password;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "memloginid")
    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getMem_role() {
        return mem_role;
    }

    public void setMem_role(String mem_role) {
        this.mem_role = mem_role;
    }

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
}
