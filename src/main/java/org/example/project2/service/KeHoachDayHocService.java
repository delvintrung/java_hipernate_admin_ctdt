package org.example.project2.service;


import org.example.project2.model.HocPhan;
import org.example.project2.model.KeHoachDayHoc;
import org.example.project2.repository.HocPhanRepository;
import org.example.project2.repository.KeHoachDayHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class KeHoachDayHocService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Autowired
    private KeHoachDayHocRepository keHoachDayHocRepository;

    public void themKeHoachDayHoc() {
        // Học kỳ 1
        themKeHoach(861301L, "HK1", "2024-2025");
        themKeHoach(861302L, "HK1", "2024-2025");
        themKeHoach(866401L, "HK1", "2024-2025");
        themKeHoach(864005L, "HK1", "2024-2025");
        themKeHoach(862101L, "HK1", "2024-2025");
        themKeHoach(862406L, "HK1", "2024-2025");

        // Học kỳ 2
        themKeHoach(861303L, "HK2", "2024-2025");
        themKeHoach(861304L, "HK2", "2024-2025");
        themKeHoach(866402L, "HK2", "2024-2025");
        themKeHoach(864006L, "HK2", "2024-2025");
        themKeHoach(862407L, "HK2", "2024-2025");

        
        themKeHoach(861305L, "HK3", "2024-2025");
        themKeHoach(866403L, "HK3", "2024-2025");
        themKeHoach(864007L, "HK3", "2024-2025");
        themKeHoach(862408L, "HK3", "2024-2025");

        
        themKeHoach(865006L, "HK4", "2024-2025");
        themKeHoach(864508L, "HK4", "2024-2025");
        themKeHoach(862409L, "HK4", "2024-2025");
    }

    private void themKeHoach(Long maHocPhan, String hocKy, String namHoc) {
        HocPhan hocPhan = hocPhanRepository.findById(maHocPhan)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học phần: " + maHocPhan));

        KeHoachDayHoc keHoach = new KeHoachDayHoc();
        keHoach.setHocPhan(hocPhan);
        keHoach.setHocKy(hocKy);
        keHoach.setNamHoc(namHoc);
        keHoachDayHocRepository.save(keHoach);
    }
    
    @Transactional
    public void deleteAll() {
        keHoachDayHocRepository.deleteAll();
    }
}
