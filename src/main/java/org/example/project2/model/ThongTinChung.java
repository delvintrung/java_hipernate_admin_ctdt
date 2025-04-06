package org.example.project2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ctdt_thongtinchung")
public class ThongTinChung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCTDT")
    private Long maCTDT;

    @Column(name = "TenCTDT", nullable = false)
    private String tenCTDT;

    @Column(name = "NamBatDau")
    private Integer namBatDau;

    @Column(name = "MoTa", columnDefinition = "TEXT")
    private String moTa;

    @OneToMany(mappedBy = "thongTinChung", cascade = CascadeType.ALL)
    private List<KhungChuongTrinh> khungChuongTrinhs;

    // Constructor
    public ThongTinChung() {
    }

    // Getter và Setter
    public Long getMaCTDT() {
        return maCTDT;
    }

    public void setMaCTDT(Long maCTDT) {
        this.maCTDT = maCTDT;
    }

    public String getTenCTDT() {
        return tenCTDT;
    }

    public void setTenCTDT(String tenCTDT) {
        this.tenCTDT = tenCTDT;
    }

    public Integer getNamBatDau() {
        return namBatDau;
    }

    public void setNamBatDau(Integer namBatDau) {
        this.namBatDau = namBatDau;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<KhungChuongTrinh> getKhungChuongTrinhs() {
        return khungChuongTrinhs;
    }

    public void setKhungChuongTrinhs(List<KhungChuongTrinh> khungChuongTrinhs) {
        this.khungChuongTrinhs = khungChuongTrinhs;
    }
}