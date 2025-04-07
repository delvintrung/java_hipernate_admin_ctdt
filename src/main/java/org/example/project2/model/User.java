package org.example.project2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_user")
public class User {

    @Id
    @Column(name = "MaUser")
    private Integer maUser;

    @Column(name = "TenUser", nullable = false)
    private String tenUser;

    // Constructor
    public User() {
    }

    // Getter và Setter
    public Integer getMaUser() {
        return maUser;
    }

    public void setMaUser(Integer maUser) {
        this.maUser = maUser;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }
}