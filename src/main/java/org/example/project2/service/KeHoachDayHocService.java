package org.example.project2.service;

import java.util.Optional;

import org.example.project2.model.HocPhan;
import org.example.project2.model.KeHoachDayHoc;
import org.example.project2.repository.HocPhanRepository;
import org.example.project2.repository.KeHoachDayHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KeHoachDayHocService {

    @Autowired
    private KeHoachDayHocRepository keHoachDayHocRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Transactional
    public void themKeHoachDayHoc() {
        // Thêm kế hoạch giảng dạy cho từng học phần
        themKeHoach(861301L, 1, null, null); // Triết học Mác – Lênin
        themKeHoach(861302L, 2, 861301L, null); // Kinh tế chính trị Mác – Lênin
        themKeHoach(861303L, 3, 861302L, null); // Chủ nghĩa xã hội khoa học
        themKeHoach(861304L, 3, 861303L, null); // Tư tưởng Hồ Chí Minh
        themKeHoach(861305L, 4, 861303L, null); // Lịch sử Đảng Cộng sản Việt Nam
        themKeHoach(866401L, 1, null, "Đạt khảo sát tiếng Anh theo quy định năm 2022"); // Tiếng Anh 1
        themKeHoach(866402L, 2, 866401L, null); // Tiếng Anh 2
        themKeHoach(866403L, 3, 866402L, null); // Tiếng Anh 3
        themKeHoach(865006L, 1, null, null); // Pháp luật đại cương
        themKeHoach(864508L, 2, null, null); // Xác suất thống kê
        themKeHoach(864005L, 1, null, null); // Giải tích 1
    }

    private void themKeHoach(Long maHocPhan, Integer hocKyThucHien, Long maHocPhanTienQuyet, String ghiChuTienQuyet) {
        // Tìm học phần
        HocPhan hocPhan = hocPhanRepository.findById(maHocPhan)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học phần với MaHocPhan: " + maHocPhan));

        // Tìm học phần tiên quyết (nếu có)
        HocPhan hocPhanTienQuyet = null;
        if (maHocPhanTienQuyet != null) {
            hocPhanTienQuyet = hocPhanRepository.findById(maHocPhanTienQuyet)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy học phần tiên quyết với MaHocPhan: " + maHocPhanTienQuyet));
        }

        // Kiểm tra xem kế hoạch đã tồn tại chưa
        Optional<KeHoachDayHoc> existingKeHoach = keHoachDayHocRepository.findByHocPhanMaHocPhan(maHocPhan);
        KeHoachDayHoc keHoach;

        if (existingKeHoach.isPresent()) {
            // Nếu đã tồn tại, cập nhật
            keHoach = existingKeHoach.get();
        } else {
            // Nếu chưa tồn tại, tạo mới
            keHoach = new KeHoachDayHoc();
            keHoach.setHocPhan(hocPhan);
        }

        // Cập nhật thông tin
        keHoach.setHocKyThucHien(hocKyThucHien);
        keHoach.setHocPhanTienQuyet(hocPhanTienQuyet);
        keHoach.setGhiChuTienQuyet(ghiChuTienQuyet);

        // Lưu hoặc cập nhật
        keHoachDayHocRepository.save(keHoach);
    }

    @Transactional
    public void deleteAll() {
        keHoachDayHocRepository.deleteAll();
    }
}