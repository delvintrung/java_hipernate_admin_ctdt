package org.example.project2.service;

import org.example.project2.model.KhoiKienThuc;
import org.example.project2.model.KhungChuongTrinh;
import org.example.project2.repository.KhoiKienThucRepository;
import org.example.project2.repository.KhungChuongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhoiKienThucService {

    @Autowired
    private KhoiKienThucRepository khoiKienThucRepository;

    @Autowired
    private KhungChuongTrinhRepository khungChuongTrinhRepository;

    public void themKhoiKienThuc() {
        // Lấy khung chương trình (giả sử MaKhung = 1)
        KhungChuongTrinh khung = khungChuongTrinhRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung chương trình"));

        // I. Khối kiến thức giáo dục đại cương
        KhoiKienThuc khoiDaiCuong = new KhoiKienThuc();
        khoiDaiCuong.setKhungChuongTrinh(khung);
        khoiDaiCuong.setTenKhoi("Khối kiến thức giáo dục đại cương");
        khoiDaiCuong.setSoTinChiBatBuoc(34);
        khoiDaiCuong.setSoTinChiTuChon(0);
        khoiKienThucRepository.save(khoiDaiCuong);

        // I.1. Kiến thức Giáo dục thể chất và Giáo dục quốc phòng và an ninh
        KhoiKienThuc khoiGDTCQP = new KhoiKienThuc();
        khoiGDTCQP.setKhungChuongTrinh(khung);
        khoiGDTCQP.setTenKhoi("Kiến thức Giáo dục thể chất và Giáo dục quốc phòng và an ninh");
        khoiGDTCQP.setSoTinChiBatBuoc(12);
        khoiGDTCQP.setSoTinChiTuChon(2);
        khoiGDTCQP.setKhoiCha(khoiDaiCuong);
        khoiKienThucRepository.save(khoiGDTCQP);

        // I.2. Kiến thức Ngoại ngữ
        KhoiKienThuc khoiNgoaiNgu = new KhoiKienThuc();
        khoiNgoaiNgu.setKhungChuongTrinh(khung);
        khoiNgoaiNgu.setTenKhoi("Kiến thức Ngoại ngữ");
        khoiNgoaiNgu.setSoTinChiBatBuoc(9);
        khoiNgoaiNgu.setSoTinChiTuChon(0);
        khoiNgoaiNgu.setKhoiCha(khoiDaiCuong);
        khoiKienThucRepository.save(khoiNgoaiNgu);

        // I.3. Kiến thức Lý luận chính trị
        KhoiKienThuc khoiLyLuan = new KhoiKienThuc();
        khoiLyLuan.setKhungChuongTrinh(khung);
        khoiLyLuan.setTenKhoi("Kiến thức Lý luận chính trị");
        khoiLyLuan.setSoTinChiBatBuoc(11);
        khoiLyLuan.setSoTinChiTuChon(0);
        khoiLyLuan.setKhoiCha(khoiDaiCuong);
        khoiKienThucRepository.save(khoiLyLuan);

        // I.4. Kiến thức giáo dục đại cương khác
        KhoiKienThuc khoiDaiCuongKhac = new KhoiKienThuc();
        khoiDaiCuongKhac.setKhungChuongTrinh(khung);
        khoiDaiCuongKhac.setTenKhoi("Kiến thức giáo dục đại cương khác");
        khoiDaiCuongKhac.setSoTinChiBatBuoc(14);
        khoiDaiCuongKhac.setSoTinChiTuChon(0);
        khoiDaiCuongKhac.setKhoiCha(khoiDaiCuong);
        khoiKienThucRepository.save(khoiDaiCuongKhac);

        // II. Khối kiến thức giáo dục chuyên nghiệp
        KhoiKienThuc khoiChuyenNghiep = new KhoiKienThuc();
        khoiChuyenNghiep.setKhungChuongTrinh(khung);
        khoiChuyenNghiep.setTenKhoi("Khối kiến thức giáo dục chuyên nghiệp");
        khoiChuyenNghiep.setSoTinChiBatBuoc(90);
        khoiChuyenNghiep.setSoTinChiTuChon(31);
        khoiKienThucRepository.save(khoiChuyenNghiep);

        // II.1. Kiến thức cơ sở của ngành
        KhoiKienThuc khoiCoSoNganh = new KhoiKienThuc();
        khoiCoSoNganh.setKhungChuongTrinh(khung);
        khoiCoSoNganh.setTenKhoi("Kiến thức cơ sở của ngành");
        khoiCoSoNganh.setSoTinChiBatBuoc(37);
        khoiCoSoNganh.setSoTinChiTuChon(0);
        khoiCoSoNganh.setKhoiCha(khoiChuyenNghiep);
        khoiKienThucRepository.save(khoiCoSoNganh);

        // II.2. Kiến thức ngành
        KhoiKienThuc khoiNganh = new KhoiKienThuc();
        khoiNganh.setKhungChuongTrinh(khung);
        khoiNganh.setTenKhoi("Kiến thức ngành");
        khoiNganh.setSoTinChiBatBuoc(37);
        khoiNganh.setSoTinChiTuChon(16);
        khoiNganh.setKhoiCha(khoiChuyenNghiep);
        khoiKienThucRepository.save(khoiNganh);

        // II.3. Kiến thức chuyên ngành (nếu có)
        KhoiKienThuc khoiChuyenNganh = new KhoiKienThuc();
        khoiChuyenNganh.setKhungChuongTrinh(khung);
        khoiChuyenNganh.setTenKhoi("Kiến thức chuyên ngành (nếu có)");
        khoiChuyenNganh.setSoTinChiBatBuoc(16);
        khoiChuyenNganh.setSoTinChiTuChon(15);
        khoiChuyenNganh.setKhoiCha(khoiChuyenNghiep);
        khoiKienThucRepository.save(khoiChuyenNganh);
    }
}