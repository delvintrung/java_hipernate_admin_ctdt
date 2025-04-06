package org.example.project2.service;

import org.example.project2.model.HocPhan;
import org.example.project2.model.KhoiKienThuc;
import org.example.project2.model.KhungChuongTrinh;
import org.example.project2.repository.HocPhanRepository;
import org.example.project2.repository.KhoiKienThucRepository;
import org.example.project2.repository.KhungChuongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Autowired
    private KhungChuongTrinhRepository khungChuongTrinhRepository;
    
    @Autowired
    private KhoiKienThucRepository khoiKienThucRepository;

    public void themHocPhan() {
    	KhungChuongTrinh khung = khungChuongTrinhRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung chương trình"));

        // Lấy các khối kiến thức
        KhoiKienThuc khoiGDTCQP = khoiKienThucRepository.findByTenKhoi("Kiến thức Giáo dục thể chất và Giáo dục quốc phòng và an ninh")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khối kiến thức"));
        KhoiKienThuc khoiNgoaiNgu = khoiKienThucRepository.findByTenKhoi("Kiến thức Ngoại ngữ")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khối kiến thức"));
        KhoiKienThuc khoiLyLuan = khoiKienThucRepository.findByTenKhoi("Kiến thức Lý luận chính trị")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khối kiến thức"));
        KhoiKienThuc khoiDaiCuongKhac = khoiKienThucRepository.findByTenKhoi("Kiến thức giáo dục đại cương khác")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khối kiến thức"));
        HocPhan hp1 = new HocPhan();
        hp1.setMaHocPhan(861301L);
        hp1.setTenHocPhan("Triết học Mác – Lênin");
        hp1.setSoTinChi(3);
        hp1.setSoTietLyThuyet(45);
        hp1.setSoTietThucHanh(0);
        hp1.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp1);

        HocPhan hp2 = new HocPhan();
        hp2.setMaHocPhan(861302L);
        hp2.setTenHocPhan("Kinh tế chính trị Mác – Lênin");
        hp2.setSoTinChi(2);
        hp2.setSoTietLyThuyet(30);
        hp2.setSoTietThucHanh(0);
        hp2.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp2);

        HocPhan hp3 = new HocPhan();
        hp3.setMaHocPhan(861303L);
        hp3.setTenHocPhan("Chủ nghĩa xã hội khoa học");
        hp3.setSoTinChi(2);
        hp3.setSoTietLyThuyet(30);
        hp3.setSoTietThucHanh(0);
        hp3.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp3);

        HocPhan hp4 = new HocPhan();
        hp4.setMaHocPhan(861304L);
        hp4.setTenHocPhan("Tư tưởng Hồ Chí Minh");
        hp4.setSoTinChi(2);
        hp4.setSoTietLyThuyet(30);
        hp4.setSoTietThucHanh(0);
        hp4.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp4);

        HocPhan hp5 = new HocPhan();
        hp5.setMaHocPhan(861305L);
        hp5.setTenHocPhan("Lịch sử Đảng Cộng sản Việt Nam");
        hp5.setSoTinChi(2);
        hp5.setSoTietLyThuyet(30);
        hp5.setSoTietThucHanh(0);
        hp5.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp5);

        HocPhan hp6 = new HocPhan();
        hp6.setMaHocPhan(866401L);
        hp6.setTenHocPhan("Tiếng Anh 1");
        hp6.setSoTinChi(3);
        hp6.setSoTietLyThuyet(45);
        hp6.setSoTietThucHanh(0);
        hp6.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp6);

        HocPhan hp7 = new HocPhan();
        hp7.setMaHocPhan(866402L);
        hp7.setTenHocPhan("Tiếng Anh 2");
        hp7.setSoTinChi(3);
        hp7.setSoTietLyThuyet(45);
        hp7.setSoTietThucHanh(0);
        hp7.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp7);

        HocPhan hp8 = new HocPhan();
        hp8.setMaHocPhan(866403L);
        hp8.setTenHocPhan("Tiếng Anh 3");
        hp8.setSoTinChi(3);
        hp8.setSoTietLyThuyet(45);
        hp8.setSoTietThucHanh(0);
        hp8.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp8);

        HocPhan hp9 = new HocPhan();
        hp9.setMaHocPhan(865006L);
        hp9.setTenHocPhan("Pháp luật đại cương");
        hp9.setSoTinChi(2);
        hp9.setSoTietLyThuyet(30);
        hp9.setSoTietThucHanh(0);
        hp9.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp9);

        HocPhan hp10 = new HocPhan();
        hp10.setMaHocPhan(864508L);
        hp10.setTenHocPhan("Xác suất thống kê");
        hp10.setSoTinChi(3);
        hp10.setSoTietLyThuyet(45);
        hp10.setSoTietThucHanh(0);
        hp10.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp10);

        HocPhan hp11 = new HocPhan();
        hp11.setMaHocPhan(864005L);
        hp11.setTenHocPhan("Giải tích 1");
        hp11.setSoTinChi(3);
        hp11.setSoTietLyThuyet(45);
        hp11.setSoTietThucHanh(0);
        hp11.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp11);

        HocPhan hp12 = new HocPhan();
        hp12.setMaHocPhan(864006L);
        hp12.setTenHocPhan("Giải tích 2");
        hp12.setSoTinChi(3);
        hp12.setSoTietLyThuyet(45);
        hp12.setSoTietThucHanh(0);
        hp12.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp12);

        HocPhan hp13 = new HocPhan();
        hp13.setMaHocPhan(864007L);
        hp13.setTenHocPhan("Đại số tuyến tính");
        hp13.setSoTinChi(3);
        hp13.setSoTietLyThuyet(45);
        hp13.setSoTietThucHanh(0);
        hp13.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp13);

        HocPhan hp14 = new HocPhan();
        hp14.setMaHocPhan(862101L);
        hp14.setTenHocPhan("Giáo dục thể chất (I)");
        hp14.setSoTinChi(1);
        hp14.setSoTietLyThuyet(2);
        hp14.setSoTietThucHanh(28);
        hp14.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp14);

        HocPhan hp15 = new HocPhan();
        hp15.setMaHocPhan(862406L);
        hp15.setTenHocPhan("Giáo dục quốc phòng và an ninh I");
        hp15.setSoTinChi(3);
        hp15.setSoTietLyThuyet(37);
        hp15.setSoTietThucHanh(8);
        hp15.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp15);

        HocPhan hp16 = new HocPhan();
        hp16.setMaHocPhan(862407L);
        hp16.setTenHocPhan("Giáo dục quốc phòng và an ninh II");
        hp16.setSoTinChi(2);
        hp16.setSoTietLyThuyet(22);
        hp16.setSoTietThucHanh(8);
        hp16.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp16);

        HocPhan hp17 = new HocPhan();
        hp17.setMaHocPhan(862408L);
        hp17.setTenHocPhan("Giáo dục quốc phòng và an ninh III");
        hp17.setSoTinChi(2);
        hp17.setSoTietLyThuyet(14);
        hp17.setSoTietThucHanh(16);
        hp17.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp17);

        HocPhan hp18 = new HocPhan();
        hp18.setMaHocPhan(862409L);
        hp18.setTenHocPhan("Giáo dục quốc phòng và an ninh IV");
        hp18.setSoTinChi(4);
        hp18.setSoTietLyThuyet(4);
        hp18.setSoTietThucHanh(56);
        hp18.setKhungChuongTrinh(khung);
        hocPhanRepository.save(hp18);
    }
}