package org.example.project2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_giangvien_hocphan")
public class GiangVienHocPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDangKy")
    private Long maDangKy;

    @ManyToOne
    @JoinColumn(name = "MaGiangVien", nullable = false)
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "MaHocPhan", nullable = false)
    private HocPhan hocPhan;

    @Column(name = "TrangThai")
    private String trangThai; // Ví dụ: "Đã đăng ký", "Đã phân công"

    // Constructor
    public GiangVienHocPhan() {
    }

    // Getter và Setter
    public Long getMaDangKy() {
        return maDangKy;
    }

    public void setMaDangKy(Long maDangKy) {
        this.maDangKy = maDangKy;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}