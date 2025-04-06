package org.example.project2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ctdt_kehoachmonhom")
public class KeHoachMoNhom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhom")
    private Long maNhom;

    @ManyToOne
    @JoinColumn(name = "MaKeHoach", nullable = false)
    private KeHoachDayHoc keHoachDayHoc;

    @Column(name = "TenNhom", nullable = false)
    private String tenNhom;

    @Column(name = "SoLuongSV")
    private Integer soLuongSV;

    @Column(name = "ThoiGian")
    private String thoiGian;

    @OneToMany(mappedBy = "keHoachMoNhom", cascade = CascadeType.ALL)
    private List<PhanCongGiangDay> phanCongGiangDays;

    // Constructor
    public KeHoachMoNhom() {
    }

    // Getter và Setter
    public Long getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(Long maNhom) {
        this.maNhom = maNhom;
    }

    public KeHoachDayHoc getKeHoachDayHoc() {
        return keHoachDayHoc;
    }

    public void setKeHoachDayHoc(KeHoachDayHoc keHoachDayHoc) {
        this.keHoachDayHoc = keHoachDayHoc;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public Integer getSoLuongSV() {
        return soLuongSV;
    }

    public void setSoLuongSV(Integer soLuongSV) {
        this.soLuongSV = soLuongSV;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public List<PhanCongGiangDay> getPhanCongGiangDays() {
        return phanCongGiangDays;
    }

    public void setPhanCongGiangDays(List<PhanCongGiangDay> phanCongGiangDays) {
        this.phanCongGiangDays = phanCongGiangDays;
    }
}