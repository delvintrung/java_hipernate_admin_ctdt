package org.example.project2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ctdt_giangvien")
public class GiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaGiangVien")
    private Long maGiangVien;

    @OneToOne
    @JoinColumn(name = "MaUser", nullable = false)
    private User user;

    @Column(name = "TenGiangVien", nullable = false)
    private String tenGiangVien;

    @Column(name = "LoaiGiangVien")
    private String loaiGiangVien; // Ví dụ: "Cơ hữu", "Thỉnh giảng"

    @OneToMany(mappedBy = "giangVien", cascade = CascadeType.ALL)
    private List<PhanCongGiangDay> phanCongGiangDays;

    // Constructor
    public GiangVien() {
    }

    // Getter và Setter
    public Long getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(Long maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getLoaiGiangVien() {
        return loaiGiangVien;
    }

    public void setLoaiGiangVien(String loaiGiangVien) {
        this.loaiGiangVien = loaiGiangVien;
    }

    public List<PhanCongGiangDay> getPhanCongGiangDays() {
        return phanCongGiangDays;
    }
    
    @OneToMany(mappedBy = "giangVien", cascade = CascadeType.ALL)
    private List<GiangVienHocPhan> giangVienHocPhans;

    public void setPhanCongGiangDays(List<PhanCongGiangDay> phanCongGiangDays) {
        this.phanCongGiangDays = phanCongGiangDays;
    }
}