package org.example.project2.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    @Column(name = "Bac") 
    private String bac;

    @Column(name = "LoaiBang")
    private String loaiBang;

    @Column(name = "LoaiHinhDaoTao")
    private String loaiHinhDaoTao;

    @Column(name = "ThoiGian")
    private String thoiGian;

    @Column(name = "SoTinChiToiThieu") 
    private Integer soTinChiToiThieu;

    @Column(name = "KhoaQuanLy")
    private String khoaQuanLy;

    @Column(name = "NgonNgu")
    private String ngonNgu;
    
    @Column(name = "Website") 
    private String website;

    @Column(name = "BanHanh", columnDefinition = "TEXT") // Thêm trường Ban hành
    private String banHanh;

    @OneToMany(mappedBy = "thongTinChung", cascade = CascadeType.ALL)
    @JsonIgnore
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
    
    public String getBac() {
        return bac;
    }

    public void setBac(String bac) {
        this.bac = bac;
    }

    public String getLoaiBang() {
        return loaiBang;
    }

    public void setLoaiBang(String loaiBang) {
        this.loaiBang = loaiBang;
    }
    
    public String getLoaiHinhDaoTao() {
        return loaiHinhDaoTao;
    }

    public void setLoaiHinhDaoTao(String loaiHinhDaoTao) {
        this.loaiHinhDaoTao = loaiHinhDaoTao;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Integer getSoTinChiToiThieu() {
        return soTinChiToiThieu;
    }

    public void setSoTinChiToiThieu(Integer soTinChiToiThieu) {
        this.soTinChiToiThieu = soTinChiToiThieu;
    }
    
    public String getKhoaQuanLy() {
        return khoaQuanLy;
    }

    public void setKhoaQuanLy(String khoaQuanLy) {
        this.khoaQuanLy = khoaQuanLy;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
    public String getBanHanh() {
        return banHanh;
    }

    public void setBanHanh(String banHanh) {
        this.banHanh = banHanh;
    }

    public List<KhungChuongTrinh> getKhungChuongTrinhs() {
        return khungChuongTrinhs;
    }

    public void setKhungChuongTrinhs(List<KhungChuongTrinh> khungChuongTrinhs) {
        this.khungChuongTrinhs = khungChuongTrinhs;
    }
}