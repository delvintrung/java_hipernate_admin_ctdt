package org.example.project2.model;

import jakarta.persistence.*;
import java.util.List;

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

    @Column(name = "HocKy", nullable = false)
    private String hocKy;

    @Column(name = "NamHoc", nullable = false)
    private String namHoc;

    @OneToMany(mappedBy = "keHoachDayHoc", cascade = CascadeType.ALL)
    private List<KeHoachMoNhom> keHoachMoNhoms;

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

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public List<KeHoachMoNhom> getKeHoachMonHoms() {
        return keHoachMoNhoms;
    }

    public void setKeHoachMonHoms(List<KeHoachMoNhom> keHoachMoNhoms) {
        this.keHoachMoNhoms = keHoachMoNhoms;
    }
}