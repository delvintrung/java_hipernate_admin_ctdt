package org.example.project2.service;

import org.example.project2.model.*;
import org.example.project2.repository.GiangVienHocPhanRepository;
import org.example.project2.repository.KeHoachMoNhomRepository;
import org.example.project2.repository.PhanCongGiangDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PhanCongService {

    @Autowired
    private KeHoachMoNhomRepository keHoachMoNhomRepository;

    @Autowired
    private GiangVienHocPhanRepository giangVienHocPhanRepository;

    @Autowired
    private PhanCongGiangDayRepository phanCongGiangDayRepository;

    @Transactional
    public void phanCongGiangDay() {
        List<KeHoachMoNhom> nhomLops = keHoachMoNhomRepository.findAll();

        // Xây dựng đồ thị
        Map<Long, List<Long>> graph = buildGraph(nhomLops);

        // Lấy danh sách giảng viên cho từng học phần
        Map<Long, List<GiangVien>> giangVienByHocPhan = getGiangVienByHocPhan();

        // Phân công giảng viên
        Map<Long, GiangVien> phanCong = assignGiangVien(nhomLops, graph, giangVienByHocPhan);

        // Lưu kết quả vào cơ sở dữ liệu
        savePhanCong(phanCong, nhomLops);
    }

    // Xây dựng đồ thị dựa trên thời gian trùng lặp
    private Map<Long, List<Long>> buildGraph(List<KeHoachMoNhom> nhomLops) {
        Map<Long, List<Long>> graph = new HashMap<>();
        for (KeHoachMoNhom nhom1 : nhomLops) {
            graph.putIfAbsent(nhom1.getMaNhom(), new ArrayList<>());
            for (KeHoachMoNhom nhom2 : nhomLops) {
                if (!nhom1.getMaNhom().equals(nhom2.getMaNhom()) &&
                    nhom1.getThoiGian().equals(nhom2.getThoiGian())) {
                    graph.get(nhom1.getMaNhom()).add(nhom2.getMaNhom());
                }
            }
        }
        return graph;
    }

    // Lấy danh sách giảng viên theo học phần
    private Map<Long, List<GiangVien>> getGiangVienByHocPhan() {
        List<GiangVienHocPhan> dangKys = giangVienHocPhanRepository.findAll();
        Map<Long, List<GiangVien>> giangVienByHocPhan = new HashMap<>();
        for (GiangVienHocPhan dk : dangKys) {
            Long maHocPhan = dk.getHocPhan().getMaHocPhan();
            giangVienByHocPhan.putIfAbsent(maHocPhan, new ArrayList<>());
            giangVienByHocPhan.get(maHocPhan).add(dk.getGiangVien());
        }
        return giangVienByHocPhan;
    }

    // Thuật toán tham lam để phân công
    private Map<Long, GiangVien> assignGiangVien(List<KeHoachMoNhom> nhomLops,
                                                 Map<Long, List<Long>> graph,
                                                 Map<Long, List<GiangVien>> giangVienByHocPhan) {
        Map<Long, GiangVien> phanCong = new HashMap<>();
        Map<Long, Set<GiangVien>> usedGiangVien = new HashMap<>();

        for (KeHoachMoNhom nhom : nhomLops) {
            Long maHocPhan = nhom.getKeHoachDayHoc().getHocPhan().getMaHocPhan();
            List<GiangVien> availableGiangViens = giangVienByHocPhan.get(maHocPhan);
            if (availableGiangViens == null || availableGiangViens.isEmpty()) {
                throw new RuntimeException("Không có giảng viên nào đăng ký học phần: " + maHocPhan);
            }

            // Lấy danh sách giảng viên đã dùng trong cùng thời gian
            Set<GiangVien> usedInTimeSlot = usedGiangVien.getOrDefault(nhom.getThoiGian().hashCode(), new HashSet<>());
            List<Long> neighbors = graph.get(nhom.getMaNhom());

            // Chọn giảng viên chưa bị trùng
            GiangVien selectedGiangVien = null;
            for (GiangVien gv : availableGiangViens) {
                if (!usedInTimeSlot.contains(gv)) {
                    selectedGiangVien = gv;
                    break;
                }
            }

            if (selectedGiangVien == null) {
                throw new RuntimeException("Không đủ giảng viên cho nhóm lớp: " + nhom.getMaNhom());
            }

            phanCong.put(nhom.getMaNhom(), selectedGiangVien);
            usedInTimeSlot.add(selectedGiangVien);
            usedGiangVien.put((long) nhom.getThoiGian().hashCode(), usedInTimeSlot);
        }
        return phanCong;
    }

    // Lưu kết quả phân công
    private void savePhanCong(Map<Long, GiangVien> phanCong, List<KeHoachMoNhom> nhomLops) {
        for (KeHoachMoNhom nhom : nhomLops) {
            PhanCongGiangDay pc = new PhanCongGiangDay();
            pc.setKeHoachMonHom(nhom);
            pc.setGiangVien(phanCong.get(nhom.getMaNhom()));
            pc.setThoiGian(nhom.getThoiGian());
            phanCongGiangDayRepository.save(pc);
        }
    }
}