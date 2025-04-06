	package org.example.project2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ctdt_hocphan")
public class HocPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHocPhan")
    private Long maHocPhan;

    @ManyToOne
    @JoinColumn(name = "MaKhung", nullable = false)
    private KhungChuongTrinh khungChuongTrinh;

    @Column(name = "TenHocPhan", nullable = false)
    private String tenHocPhan;

    @Column(name = "SoTinChi")
    private Integer soTinChi;
    
    @Column(name = "SoTietLyThuyet") 
    private Integer soTietLyThuyet;

    @Column(name = "SoTietThucHanh") 
    private Integer soTietThucHanh;

    @OneToOne(mappedBy = "hocPhan", cascade = CascadeType.ALL)
    private DeCuongChiTiet deCuongChiTiet;

    @OneToMany(mappedBy = "hocPhan", cascade = CascadeType.ALL)
    private List<KeHoachDayHoc> keHoachDayHocs;
    
    @OneToMany(mappedBy = "hocPhan", cascade = CascadeType.ALL) 
    private List<GiangVienHocPhan> giangVienHocPhans;

    // Constructor
    public HocPhan() {
    }

    // Getter và Setter
    public Long getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(Long maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public KhungChuongTrinh getKhungChuongTrinh() {
        return khungChuongTrinh;
    }

    public void setKhungChuongTrinh(KhungChuongTrinh khungChuongTrinh) {
        this.khungChuongTrinh = khungChuongTrinh;
    }
    
    public Integer getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(Integer soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public Integer getSoTietThucHanh() {
        return soTietThucHanh;
    }

    public void setSoTietThucHanh(Integer soTietThucHanh) {
        this.soTietThucHanh = soTietThucHanh;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public Integer getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi;
    }

    public DeCuongChiTiet getDeCuongChiTiet() {
        return deCuongChiTiet;
    }

    public void setDeCuongChiTiet(DeCuongChiTiet deCuongChiTiet) {
        this.deCuongChiTiet = deCuongChiTiet;
    }

    public List<KeHoachDayHoc> getKeHoachDayHocs() {
        return keHoachDayHocs;
    }

    public void setKeHoachDayHocs(List<KeHoachDayHoc> keHoachDayHocs) {
        this.keHoachDayHocs = keHoachDayHocs;
    }
}