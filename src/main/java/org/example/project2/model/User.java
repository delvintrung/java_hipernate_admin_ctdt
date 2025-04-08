package org.example.project2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_user")
public class User {

    @Id
    @Column(name = "MaUser")
    private Integer maUser;

    @Column(name = "Email", length = 255)
    private String email;

    @Column(name = "TenUser", length = 255)
    private String tenUser;

    @Column(name = "VaiTro", length = 255)
    private String vaiTro;

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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
}