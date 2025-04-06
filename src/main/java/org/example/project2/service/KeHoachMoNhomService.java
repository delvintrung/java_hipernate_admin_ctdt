package org.example.project2.service;


import org.example.project2.model.KeHoachDayHoc;
import org.example.project2.model.KeHoachMoNhom;
import org.example.project2.repository.KeHoachDayHocRepository;
import org.example.project2.repository.KeHoachMoNhomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeHoachMoNhomService {

    @Autowired
    private KeHoachDayHocRepository keHoachDayHocRepository;

    @Autowired
    private KeHoachMoNhomRepository keHoachMonHomRepository;

    public void themKeHoachMonHom() {
        // Học kỳ 1
        themNhomLop(861301L, "Nhóm 1", 50, "T2 1-3");
        themNhomLop(861302L, "Nhóm 1", 50, "T3 1-3");
        themNhomLop(866401L, "Nhóm 1", 50, "T4 1-3");
        themNhomLop(864005L, "Nhóm 1", 50, "T5 1-3");
        themNhomLop(862101L, "Nhóm 1", 50, "T6 1-3");
        themNhomLop(862406L, "Nhóm 1", 50, "T7 1-3");

        // Học kỳ 2
        themNhomLop(861303L, "Nhóm 1", 50, "T2 4-6");
        themNhomLop(861304L, "Nhóm 1", 50, "T3 4-6");
        themNhomLop(866402L, "Nhóm 1", 50, "T4 4-6");
        themNhomLop(864006L, "Nhóm 1", 50, "T5 4-6");
        themNhomLop(862407L, "Nhóm 1", 50, "T6 4-6");

        // Học kỳ 3
        themNhomLop(861305L, "Nhóm 1", 50, "T2 7-9");
        themNhomLop(866403L, "Nhóm 1", 50, "T3 7-9");
        themNhomLop(864007L, "Nhóm 1", 50, "T4 7-9");
        themNhomLop(862408L, "Nhóm 1", 50, "T5 7-9");

        // Học kỳ 4
        themNhomLop(865006L, "Nhóm 1", 50, "T2 10-12");
        themNhomLop(864508L, "Nhóm 1", 50, "T3 10-12");
        themNhomLop(862409L, "Nhóm 1", 50, "T4 10-12");
    }

    private void themNhomLop(Long maHocPhan, String tenNhom, Integer soLuongSV, String thoiGian) {
        KeHoachDayHoc keHoach = keHoachDayHocRepository.findByHocPhanMaHocPhan(maHocPhan)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy kế hoạch dạy học cho học phần: " + maHocPhan));

        KeHoachMoNhom nhom = new KeHoachMoNhom();
        nhom.setKeHoachDayHoc(keHoach);
        nhom.setTenNhom(tenNhom);
        nhom.setSoLuongSV(soLuongSV);
        nhom.setThoiGian(thoiGian);
        keHoachMonHomRepository.save(nhom);
    }
}
