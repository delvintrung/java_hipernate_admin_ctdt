package org.example.project2.service;

import java.util.Optional;

import org.example.project2.model.HocPhan;
import org.example.project2.model.KhoiKienThuc;
import org.example.project2.model.KhungChuongTrinh;
import org.example.project2.repository.HocPhanRepository;
import org.example.project2.repository.KhoiKienThucRepository;
import org.example.project2.repository.KhungChuongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Autowired
    private KhungChuongTrinhRepository khungChuongTrinhRepository;
    
    @Autowired
    private KhoiKienThucRepository khoiKienThucRepository;

    @Transactional
    public void themHocPhan() {
        KhungChuongTrinh khung = khungChuongTrinhRepository.findById(13L)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung chương trình"));

        KhoiKienThuc khoiGDTCQP = khoiKienThucRepository.findByTenKhoi("Kiến thức Giáo dục thể chất và Giáo dục quốc phòng và an ninh")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khối kiến thức"));
        KhoiKienThuc khoiNgoaiNgu = khoiKienThucRepository.findByTenKhoi("Kiến thức Ngoại ngữ")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khối kiến thức"));
        KhoiKienThuc khoiLyLuan = khoiKienThucRepository.findByTenKhoi("Kiến thức Lý luận chính trị")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khối kiến thức"));
        KhoiKienThuc khoiDaiCuongKhac = khoiKienThucRepository.findByTenKhoi("Kiến thức giáo dục đại cương khác")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khối kiến thức"));

        themHoacCapNhatHocPhan(861301L, "Triết học Mác – Lênin", 3, 45, 0, khung, khoiLyLuan);
        themHoacCapNhatHocPhan(861302L, "Kinh tế chính trị Mác – Lênin", 2, 30, 0, khung, khoiLyLuan);
        themHoacCapNhatHocPhan(861303L, "Chủ nghĩa xã hội khoa học", 2, 30, 0, khung, khoiLyLuan);
        themHoacCapNhatHocPhan(861304L, "Tư tưởng Hồ Chí Minh", 2, 30, 0, khung, khoiLyLuan);
        themHoacCapNhatHocPhan(861305L, "Lịch sử Đảng Cộng sản Việt Nam", 2, 30, 0, khung, khoiLyLuan);
        themHoacCapNhatHocPhan(866401L, "Tiếng Anh 1", 3, 45, 0, khung, khoiNgoaiNgu);
        themHoacCapNhatHocPhan(866402L, "Tiếng Anh 2", 3, 45, 0, khung, khoiNgoaiNgu);
        themHoacCapNhatHocPhan(866403L, "Tiếng Anh 3", 3, 45, 0, khung, khoiNgoaiNgu);
        themHoacCapNhatHocPhan(865006L, "Pháp luật đại cương", 2, 30, 0, khung, khoiDaiCuongKhac);
        themHoacCapNhatHocPhan(864508L, "Xác suất thống kê", 3, 45, 0, khung, khoiDaiCuongKhac);
        themHoacCapNhatHocPhan(864005L, "Giải tích 1", 3, 45, 0, khung, khoiDaiCuongKhac);
        themHoacCapNhatHocPhan(864006L, "Giải tích 2", 3, 45, 0, khung, khoiDaiCuongKhac);
        themHoacCapNhatHocPhan(864007L, "Đại số tuyến tính", 3, 45, 0, khung, khoiDaiCuongKhac);
        themHoacCapNhatHocPhan(862101L, "Giáo dục thể chất (I)", 1, 2, 28, khung, khoiGDTCQP);
        themHoacCapNhatHocPhan(862406L, "Giáo dục quốc phòng và an ninh I", 3, 37, 8, khung, khoiGDTCQP);
        themHoacCapNhatHocPhan(862407L, "Giáo dục quốc phòng và an ninh II", 2, 22, 8, khung, khoiGDTCQP);
        themHoacCapNhatHocPhan(862408L, "Giáo dục quốc phòng và an ninh III", 2, 14, 16, khung, khoiGDTCQP);
        themHoacCapNhatHocPhan(862409L, "Giáo dục quốc phòng và an ninh IV", 4, 4, 56, khung, khoiGDTCQP);
    }
    
    private void themHoacCapNhatHocPhan(Long maHocPhan, String tenHocPhan, Integer soTinChi,
            Integer soTietLyThuyet, Integer soTietThucHanh,
            KhungChuongTrinh khung, KhoiKienThuc khoiKienThuc) {
        Optional<HocPhan> existingHocPhan = hocPhanRepository.findById(maHocPhan);
        HocPhan hocPhan;
        
        if (existingHocPhan.isPresent()) {
            hocPhan = existingHocPhan.get();
        } else {
            hocPhan = new HocPhan();
            hocPhan.setMaHocPhan(maHocPhan);
        }

        hocPhan.setTenHocPhan(tenHocPhan);
        hocPhan.setSoTinChi(soTinChi);
        hocPhan.setSoTietLyThuyet(soTietLyThuyet);
        hocPhan.setSoTietThucHanh(soTietThucHanh);
        hocPhan.setKhungChuongTrinh(khung);
        hocPhan.setKhoiKienThuc(khoiKienThuc);
        
        // Lưu hoặc cập nhật
        hocPhanRepository.save(hocPhan);
    }
    
    @Transactional
    public void deleteAll() {
        hocPhanRepository.deleteAll();
    }
}