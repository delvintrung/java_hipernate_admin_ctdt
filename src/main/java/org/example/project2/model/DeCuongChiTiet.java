package org.example.project2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_decuongchitiet")
public class DeCuongChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDeCuong")
    private Long maDeCuong;

    @OneToOne
    @JoinColumn(name = "MaHocPhan", nullable = false)
    private HocPhan hocPhan;

    @Column(name = "DanhGia", columnDefinition = "TEXT")
    private String danhGia;

    @Column(name = "TaiLieuThamKhao", columnDefinition = "TEXT")
    private String taiLieuThamKhao;

    // Constructor
    public DeCuongChiTiet() {
    }

    // Getter và Setter
    public Long getMaDeCuong() {
        return maDeCuong;
    }

    public void setMaDeCuong(Long maDeCuong) {
        this.maDeCuong = maDeCuong;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }


    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public String getTaiLieuThamKhao() {
        return taiLieuThamKhao;
    }

    public void setTaiLieuThamKhao(String taiLieuThamKhao) {
        this.taiLieuThamKhao = taiLieuThamKhao;
    }
}