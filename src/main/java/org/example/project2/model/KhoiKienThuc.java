package org.example.project2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ctdt_khoikienthuc")
public class KhoiKienThuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhoi")
    private Long maKhoi;

    @ManyToOne
    @JoinColumn(name = "MaKhung", nullable = false)
    private KhungChuongTrinh khungChuongTrinh;

    @Column(name = "TenKhoi", nullable = false)
    private String tenKhoi;

    @Column(name = "SoTinChiBatBuoc")
    private Integer soTinChiBatBuoc;

    @Column(name = "SoTinChiTuChon")
    private Integer soTinChiTuChon;

    @ManyToOne
    @JoinColumn(name = "MaKhoiCha") 
    private KhoiKienThuc khoiCha;

    @OneToMany(mappedBy = "khoiCha", cascade = CascadeType.ALL)
    private List<KhoiKienThuc> khoiCon;

    // Constructor
    public KhoiKienThuc() {
    }

    // Getter và Setter
    public Long getMaKhoi() {
        return maKhoi;
    }

    public void setMaKhoi(Long maKhoi) {
        this.maKhoi = maKhoi;
    }

    public KhungChuongTrinh getKhungChuongTrinh() {
        return khungChuongTrinh;
    }

    public void setKhungChuongTrinh(KhungChuongTrinh khungChuongTrinh) {
        this.khungChuongTrinh = khungChuongTrinh;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }

    public Integer getSoTinChiBatBuoc() {
        return soTinChiBatBuoc;
    }

    public void setSoTinChiBatBuoc(Integer soTinChiBatBuoc) {
        this.soTinChiBatBuoc = soTinChiBatBuoc;
    }

    public Integer getSoTinChiTuChon() {
        return soTinChiTuChon;
    }

    public void setSoTinChiTuChon(Integer soTinChiTuChon) {
        this.soTinChiTuChon = soTinChiTuChon;
    }

    public KhoiKienThuc getKhoiCha() {
        return khoiCha;
    }

    public void setKhoiCha(KhoiKienThuc khoiCha) {
        this.khoiCha = khoiCha;
    }

    public List<KhoiKienThuc> getKhoiCon() {
        return khoiCon;
    }

    public void setKhoiCon(List<KhoiKienThuc> khoiCon) {
        this.khoiCon = khoiCon;
    }
}