package org.example.project2.controller;

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
            hocPhanService.themHocPhan();
            keHoachDayHocService.themKeHoachDayHoc();
            keHoachMoNhomService.themKeHoachMonHom();
            return "Thêm dữ liệu thành công!";
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }
}