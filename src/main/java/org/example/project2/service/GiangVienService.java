package org.example.project2.service;

import org.example.project2.model.GiangVien;
import org.example.project2.model.User;
import org.example.project2.repository.GiangVienRepository;
import org.example.project2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void themGiangVien() {
        // Thêm giảng viên 1
        themHoacCapNhatGiangVien(1, "Nguyễn Văn A", "Cơ hữu");
        // Thêm giảng viên 2
        themHoacCapNhatGiangVien(2, "Trần Thị B", "Cơ hữu");
        // Thêm giảng viên 3
        themHoacCapNhatGiangVien(3, "Lê Văn C", "Thỉnh giảng");
        // Thêm giảng viên 4
        themHoacCapNhatGiangVien(4, "Phạm Thị D", "Cơ hữu");
        // Thêm giảng viên 5
        themHoacCapNhatGiangVien(5, "Hoàng Văn E", "Thỉnh giảng");
    }

    private void themHoacCapNhatGiangVien(Integer maUser, String tenGiangVien, String loaiGiangVien) { // Thay đổi từ String thành Integer
        // Tìm user theo MaUser
        User user = userRepository.findById(maUser)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user với MaUser: " + maUser));

        // Kiểm tra xem giảng viên đã tồn tại chưa
        Optional<GiangVien> existingGiangVien = giangVienRepository.findByTenGiangVien(tenGiangVien);
        GiangVien giangVien;

        if (existingGiangVien.isPresent()) {
            // Nếu đã tồn tại, cập nhật
            giangVien = existingGiangVien.get();
        } else {
            // Nếu chưa tồn tại, tạo mới
            giangVien = new GiangVien();
            giangVien.setUser(user);
        }

        // Cập nhật thông tin
        giangVien.setTenGiangVien(tenGiangVien);
        giangVien.setLoaiGiangVien(loaiGiangVien);

        // Lưu hoặc cập nhật
        giangVienRepository.save(giangVien);
    }

    @Transactional
    public void deleteAll() {
        giangVienRepository.deleteAll();
    }
}