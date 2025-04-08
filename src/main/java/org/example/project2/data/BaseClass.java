package org.example.project2.data;

import java.util.List;


class User {
    private int maUser;
    private String tenUser;

    public int getMaUser() { return maUser; }
    public String getTenUser() { return tenUser; }
}

class GiangVien {
    private int maGiangVien;
    private User user;
    private String tenGiangVien;
    private String loaiGiangVien;
    private List<Object> phanCongGiangDays;

    public int getMaGiangVien() { return maGiangVien; }
    public User getUser() { return user; }
    public String getTenGiangVien() { return tenGiangVien; }
    public String getLoaiGiangVien() { return loaiGiangVien; }
    public List<Object> getPhanCongGiangDays() { return phanCongGiangDays; }
}