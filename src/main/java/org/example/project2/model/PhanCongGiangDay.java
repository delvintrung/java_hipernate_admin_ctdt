package org.example.project2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_phanconggiangday")
public class PhanCongGiangDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhanCong")
    private Long maPhanCong;

    @ManyToOne
    @JoinColumn(name = "MaNhom", nullable = false)
    private KeHoachMoNhom keHoachMoNhom;

    @ManyToOne
    @JoinColumn(name = "MaGiangVien", nullable = false)
    private GiangVien giangVien;

    @Column(name = "ThoiGian")
    private String thoiGian;

    // Constructor
    public PhanCongGiangDay() {
    }

    // Getter và Setter
    public Long getMaPhanCong() {
        return maPhanCong;
    }

    public void setMaPhanCong(Long maPhanCong) {
        this.maPhanCong = maPhanCong;
    }

    public KeHoachMoNhom getKeHoachMoNhom() {
        return keHoachMoNhom;
    }

    public void setKeHoachMonHom(KeHoachMoNhom keHoachMoNhom) {
        this.keHoachMoNhom = keHoachMoNhom;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}