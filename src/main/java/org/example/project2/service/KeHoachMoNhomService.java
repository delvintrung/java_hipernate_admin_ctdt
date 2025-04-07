package org.example.project2.service;

import org.example.project2.model.KeHoachDayHoc;
import org.example.project2.model.KeHoachMoNhom;
import org.example.project2.repository.KeHoachDayHocRepository;
import org.example.project2.repository.KeHoachMoNhomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KeHoachMoNhomService {

    @Autowired
    private KeHoachDayHocRepository keHoachDayHocRepository;

    @Autowired
    private KeHoachMoNhomRepository keHoachMonHomRepository;

    @Transactional
    public void themKeHoachMoNhom() {
        // Học kỳ 1
        themNhomLop(861301L, "Nhóm 1", 50, "T2 1-3", 1); // Triết học Mác – Lênin
        themNhomLop(866401L, "Nhóm 1", 50, "T3 1-3", 1); // Tiếng Anh 1
        themNhomLop(865006L, "Nhóm 1", 50, "T4 1-3", 1); // Pháp luật đại cương
        themNhomLop(864005L, "Nhóm 1", 50, "T5 1-3", 1); // Giải tích 1

        // Học kỳ 2
        themNhomLop(861302L, "Nhóm 1", 50, "T2 4-6", 2); // Kinh tế chính trị Mác – Lênin
        themNhomLop(866402L, "Nhóm 1", 50, "T3 4-6", 2); // Tiếng Anh 2
        themNhomLop(864508L, "Nhóm 1", 50, "T4 4-6", 2); // Xác suất thống kê

        // Học kỳ 3
        themNhomLop(861303L, "Nhóm 1", 50, "T2 7-9", 3); // Chủ nghĩa xã hội khoa học
        themNhomLop(861304L, "Nhóm 1", 50, "T3 7-9", 3); // Tư tưởng Hồ Chí Minh
        themNhomLop(866403L, "Nhóm 1", 50, "T4 7-9", 3); // Tiếng Anh 3

        // Học kỳ 4
        themNhomLop(861305L, "Nhóm 1", 50, "T2 10-12", 4); // Lịch sử Đảng Cộng sản Việt Nam
    }

    private void themNhomLop(Long maHocPhan, String tenNhom, Integer soLuongSV, String thoiGian, Integer expectedHocKy) {
        // Tìm kế hoạch dạy học theo mã học phần
        KeHoachDayHoc keHoach = keHoachDayHocRepository.findByHocPhanMaHocPhan(maHocPhan)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy kế hoạch dạy học cho học phần: " + maHocPhan));

        // Kiểm tra học kỳ thực hiện
        if (!keHoach.getHocKyThucHien().equals(expectedHocKy)) {
            throw new RuntimeException("Học kỳ thực hiện của học phần " + maHocPhan + " không khớp. Dự kiến: " + expectedHocKy + ", Thực tế: " + keHoach.getHocKyThucHien());
        }

        // Tạo nhóm lớp
        KeHoachMoNhom nhom = new KeHoachMoNhom();
        nhom.setKeHoachDayHoc(keHoach);
        nhom.setTenNhom(tenNhom);
        nhom.setSoLuongSV(soLuongSV);
        nhom.setThoiGian(thoiGian);

        // Lưu nhóm lớp
        keHoachMonHomRepository.save(nhom);
    }

    @Transactional
    public void deleteAll() {
        keHoachMonHomRepository.deleteAll();
    }
}