package org.example.project2.service;

import org.example.project2.model.KhungChuongTrinh;
import org.example.project2.model.ThongTinChung;
import org.example.project2.repository.KhungChuongTrinhRepository;
import org.example.project2.repository.ThongTinChungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class KhungChuongTrinhService {

    @Autowired
    private KhungChuongTrinhRepository khungChuongTrinhRepository;

    @Autowired
    private ThongTinChungRepository thongTinChungRepository;

    /**
     * Thêm một khung chương trình mới
     * @param maCTDT Mã chương trình đào tạo (ThongTinChung)
     * @param moTa Mô tả khung chương trình
     * @return Khung chương trình vừa được thêm
     */
    @Transactional
    public KhungChuongTrinh themKhungChuongTrinh(Long maCTDT, String moTa) {
        ThongTinChung thongTinChung = thongTinChungRepository.findById(maCTDT)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin chương trình với MaCTDT: " + maCTDT));

        KhungChuongTrinh khung = new KhungChuongTrinh();
        khung.setThongTinChung(thongTinChung);
        khung.setMoTa(moTa);

        return khungChuongTrinhRepository.save(khung);
    }

    /**
     * Cập nhật thông tin khung chương trình
     * @param maKhung Mã khung chương trình cần cập nhật
     * @param moTa Mô tả mới
     * @return Khung chương trình đã được cập nhật
     */
    @Transactional
    public KhungChuongTrinh capNhatKhungChuongTrinh(Long maKhung, String moTa) {
        // Tìm khung chương trình theo maKhung
        KhungChuongTrinh khung = khungChuongTrinhRepository.findById(maKhung)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung chương trình với MaKhung: " + maKhung));

        // Cập nhật mô tả
        khung.setMoTa(moTa);

        // Lưu lại
        return khungChuongTrinhRepository.save(khung);
    }

    /**
     * Xóa khung chương trình
     * @param maKhung Mã khung chương trình cần xóa
     */
    @Transactional
    public void xoaKhungChuongTrinh(Long maKhung) {
        // Kiểm tra khung chương trình có tồn tại không
        KhungChuongTrinh khung = khungChuongTrinhRepository.findById(maKhung)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung chương trình với MaKhung: " + maKhung));

        // Xóa khung chương trình (các bảng liên quan như KhoiKienThuc, HocPhan sẽ tự động bị xóa nhờ cascade)
        khungChuongTrinhRepository.delete(khung);
    }

    /**
     * Lấy danh sách tất cả khung chương trình
     * @return Danh sách khung chương trình
     */
    public List<KhungChuongTrinh> getAllKhungChuongTrinh() {
        return khungChuongTrinhRepository.findAll();
    }

    /**
     * Lấy khung chương trình theo ID
     * @param maKhung Mã khung chương trình
     * @return Khung chương trình
     */
    public KhungChuongTrinh getKhungChuongTrinhById(Long maKhung) {
        return khungChuongTrinhRepository.findById(maKhung)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung chương trình với MaKhung: " + maKhung));
    }

   
    public List<KhungChuongTrinh> getKhungChuongTrinhByThongTinChung(Long maCTDT) {
        ThongTinChung thongTinChung = thongTinChungRepository.findById(maCTDT)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin chương trình với MaCTDT: " + maCTDT));
        return thongTinChung.getKhungChuongTrinhs();
    }
    
    @Transactional
    public void deleteAll() {
        khungChuongTrinhRepository.deleteAll();
    }
}