package org.example.project2.service;

import org.example.project2.model.GiangVien;
import org.example.project2.model.User;
import org.example.project2.repository.GiangVienRepository;
import org.example.project2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void themGiangVien() {
        themHoacCapNhatGiangVien(1, "Nguyễn Văn A", "Cơ hữu");
        themHoacCapNhatGiangVien(2, "Trần Thị B", "Cơ hữu");
        themHoacCapNhatGiangVien(3, "Lê Văn C", "Thỉnh giảng");
        themHoacCapNhatGiangVien(4, "Phạm Thị D", "Cơ hữu");
        themHoacCapNhatGiangVien(5, "Hoàng Văn E", "Thỉnh giảng");
    }

    private void themHoacCapNhatGiangVien(Integer maUser, String tenGiangVien, String loaiGiangVien) { 
        User user = userRepository.findById(maUser)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user với MaUser: " + maUser));

        
        Optional<GiangVien> existingGiangVien = giangVienRepository.findByTenGiangVien(tenGiangVien);
        GiangVien giangVien;

        if (existingGiangVien.isPresent()) {
            giangVien = existingGiangVien.get();
        } else {
            giangVien = new GiangVien();
        }

        giangVien.setTenGiangVien(tenGiangVien);
        giangVien.setLoaiGiangVien(loaiGiangVien);

        
        giangVienRepository.save(giangVien);
    }
    
    @Transactional
    public GiangVien themGiangVienTrucTiep(GiangVien giangVien) {

        
        Optional<GiangVien> existingGiangVien = giangVienRepository.findByTenGiangVien(giangVien.getTenGiangVien());
        GiangVien giangVienToSave;

        if (existingGiangVien.isPresent()) {
            giangVienToSave = existingGiangVien.get();
        } else {
            giangVienToSave = new GiangVien();
        }

        giangVienToSave.setTenGiangVien(giangVien.getTenGiangVien());
        giangVienToSave.setLoaiGiangVien(giangVien.getLoaiGiangVien());
        giangVienToSave.setUser(null);

        return giangVienRepository.save(giangVienToSave);
    }
    
    @Transactional(readOnly = true)
    public List<GiangVien> layTatCaGiangVien() {
        return giangVienRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public GiangVien layGiangVienTheoMa(Long maGiangVien) {
        return giangVienRepository.findById(maGiangVien)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên với MaGiangVien: " + maGiangVien));
    }
    
    @Transactional(readOnly = true)
    public GiangVien layGiangVienTheoTen(String tenGiangVien) {
        return giangVienRepository.findByTenGiangVien(tenGiangVien)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên với TenGiangVien: " + tenGiangVien));
    }
    
    @Transactional(readOnly = true)
    public List<GiangVien> layGiangVienTheoLoai(String loaiGiangVien) {
        List<GiangVien> giangViens = giangVienRepository.findByLoaiGiangVien(loaiGiangVien);
        if (giangViens.isEmpty()) {
            throw new RuntimeException("Không tìm thấy giảng viên với LoaiGiangVien: " + loaiGiangVien);
        }
        return giangViens;
    }

    @Transactional
    public void deleteAll() {
        giangVienRepository.deleteAll();
    }
}