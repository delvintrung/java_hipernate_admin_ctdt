package org.example.project2.controller;

import org.example.project2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/setup")
public class SetupController {
	@Autowired
    private UserService userService;
	@Autowired
    private GiangVienService giangVienService;

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
    private KeHoachMoNhomService keHoachMonHomService;

    @PostMapping("/init-data")
    public String initData() {
        try {
            
        	keHoachMonHomService.deleteAll(); 
            keHoachDayHocService.deleteAll(); 
            hocPhanService.deleteAll(); 
            khoiKienThucService.deleteAll();
            khungChuongTrinhService.deleteAll(); 
            thongTinChungService.deleteAll();
            giangVienService.deleteAll();
            userService.deleteAll();

            // Thêm dữ liệu mới
            userService.themUser(); 
            giangVienService.themGiangVien();
            thongTinChungService.themThongTinChung();
            khungChuongTrinhService.themKhungChuongTrinh(
                    17L,
                    "Khung chương trình đào tạo ngành Công nghệ thông tin, áp dụng từ kỳ 2024-2028, bao gồm 155 tín chỉ trong 4.5 năm."
            );
            khoiKienThucService.themKhoiKienThuc();
            hocPhanService.themHocPhan();
            keHoachDayHocService.themKeHoachDayHoc(); // Thêm kế hoạch giảng dạy
            keHoachMonHomService.themKeHoachMoNhom();

            return "Thêm dữ liệu thành công!";
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }
}