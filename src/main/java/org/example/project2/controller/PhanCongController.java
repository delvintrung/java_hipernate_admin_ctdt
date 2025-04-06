package org.example.project2.controller;

import org.example.project2.service.PhanCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/phancong")
public class PhanCongController {

    @Autowired
    private PhanCongService phanCongService;

    @PostMapping("/run")
    public String runPhanCong() {
        try {
            phanCongService.phanCongGiangDay();
            return "Phân công giảng dạy thành công!";
        } catch (Exception e) {
            return "Lỗi: " + e.getMessage();
        }
    }
}