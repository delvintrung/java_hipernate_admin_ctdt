package org.example.project2.controller;

import org.example.project2.repository.HocPhanRepository;
import org.example.project2.repository.KhoiKienThucRepository;
import org.example.project2.repository.KhungChuongTrinhRepository;
import org.example.project2.repository.ThongTinChungRepository;
import org.example.project2.service.HocPhanService;
import org.example.project2.service.KeHoachDayHocService;
import org.example.project2.service.KeHoachMoNhomService;
import org.example.project2.service.KhoiKienThucService;
import org.example.project2.service.KhungChuongTrinhService;
import org.example.project2.service.ThongTinChungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/setup")
public class SetupController {
	@Autowired
	HocPhanRepository hocPhanRepository;
	@Autowired
	KhoiKienThucRepository khoiKienThucRepository;
	@Autowired
	KhungChuongTrinhRepository khungChuongTrinhRepository;
	@Autowired
	ThongTinChungRepository thongTinChungRepository;

	@Autowired
    private ThongTinChungService thongTinChungService;

    @Autowired
    private KhungChuongTrinhService khungChuongTrinhService;

    @Autowired
    private KhoiKienThucService khoiKienThucService;

    @Autowired
    private HocPhanService hocPhanService;

    @Autowired
    private KeHoachDayHocService keHoachDayHocService;

    @Autowired
    private KeHoachMoNhomService keHoachMoNhomService;

    @PostMapping("/init-data")
    public String initData() {
        try {
        	
        	keHoachMoNhomService.deleteAll(); // Xóa nhóm lớp trước
            keHoachDayHocService.deleteAll(); // Xóa kế hoạch dạy học
            hocPhanService.deleteAll(); // Xóa học phần
            khoiKienThucService.deleteAll(); // Xóa khối kiến thức (đã xử lý quan hệ cha-con)
            khungChuongTrinhService.deleteAll(); // Xóa khung chương trình
            thongTinChungService.deleteAll();
            // Thêm dữ liệu mới
            thongTinChungService.themThongTinChung();
            khungChuongTrinhService.themKhungChuongTrinh(
                    6L,
                    "Khung chương trình đào tạo ngành Công nghệ thông tin, áp dụng từ kỳ 2024-2028, bao gồm 155 tín chỉ trong 4.5 năm."
            );
            khoiKienThucService.themKhoiKienThuc();
            hocPhanService.themHocPhan();
            keHoachDayHocService.themKeHoachDayHoc();
            keHoachMoNhomService.themKeHoachMoNhom();
            return "Thêm dữ liệu thành công!";
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }
}