package org.example.project2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_kehoachdayhoc")
public class KeHoachDayHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKeHoach")
    private Long maKeHoach;

    @ManyToOne
    @JoinColumn(name = "MaHocPhan", nullable = false)
    private HocPhan hocPhan;

    @Column(name = "HocKyThucHien", nullable = false)
    private Integer hocKyThucHien = 1;

    @ManyToOne
    @JoinColumn(name = "MaHocPhanTienQuyet")
    private HocPhan hocPhanTienQuyet;

    @Column(name = "GhiChuTienQuyet")
    private String ghiChuTienQuyet;

    // Constructor
    public KeHoachDayHoc() {
    }

    // Getter và Setter
    public Long getMaKeHoach() {
        return maKeHoach;
    }

    public void setMaKeHoach(Long maKeHoach) {
        this.maKeHoach = maKeHoach;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public Integer getHocKyThucHien() {
        return hocKyThucHien;
    }

    public void setHocKyThucHien(Integer hocKyThucHien) {
        this.hocKyThucHien = hocKyThucHien;
    }

    public HocPhan getHocPhanTienQuyet() {
        return hocPhanTienQuyet;
    }

    public void setHocPhanTienQuyet(HocPhan hocPhanTienQuyet) {
        this.hocPhanTienQuyet = hocPhanTienQuyet;
    }

    public String getGhiChuTienQuyet() {
        return ghiChuTienQuyet;
    }

    public void setGhiChuTienQuyet(String ghiChuTienQuyet) {
        this.ghiChuTienQuyet = ghiChuTienQuyet;
    }
}