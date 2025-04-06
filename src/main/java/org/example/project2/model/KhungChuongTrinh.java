package org.example.project2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ctdt_khungchuongtrinh")
public class KhungChuongTrinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhung")
    private Long maKhung;

    @ManyToOne
    @JoinColumn(name = "MaCTDT", nullable = false)
    private ThongTinChung thongTinChung;

    @Column(name = "MoTa", columnDefinition = "TEXT")
    private String moTa;

    @OneToMany(mappedBy = "khungChuongTrinh", cascade = CascadeType.ALL)
    private List<HocPhan> hocPhans;

    // Constructor
    public KhungChuongTrinh() {
    }

    // Getter và Setter
    public Long getMaKhung() {
        return maKhung;
    }

    public void setMaKhung(Long maKhung) {
        this.maKhung = maKhung;
    }

    public ThongTinChung getThongTinChung() {
        return thongTinChung;
    }

    public void setThongTinChung(ThongTinChung thongTinChung) {
        this.thongTinChung = thongTinChung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<HocPhan> getHocPhans() {
        return hocPhans;
    }

    public void setHocPhans(List<HocPhan> hocPhans) {
        this.hocPhans = hocPhans;
    }
}