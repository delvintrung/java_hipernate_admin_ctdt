package org.example.project2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaUser")
    private Long maUser;

    @Column(name = "TenUser", nullable = false)
    private String tenUser;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "VaiTro")
    private String vaiTro; // Ví dụ: "Giảng viên", "Quản lý"

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private GiangVien giangVien;

    // Constructor
    public User() {
    }

    // Getter và Setter
    public Long getMaUser() {
        return maUser;
    }

    public void setMaUser(Long maUser) {
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

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }
}