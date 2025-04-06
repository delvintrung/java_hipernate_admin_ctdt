package org.example.project2.service;

import org.example.project2.model.ThongTinChung;
import org.example.project2.repository.ThongTinChungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThongTinChungService {

    @Autowired
    private ThongTinChungRepository thongTinChungRepository;

    public void themThongTinChung() {
        ThongTinChung thongTinChung = new ThongTinChung();
        thongTinChung.setTenCTDT("Chương trình đào tạo ngành Công nghệ thông tin");
        thongTinChung.setNamBatDau(2007);
        thongTinChung.setMoTa("Chương trình đào tạo kỹ sư Công nghệ thông tin (CNTT) đào tạo hệ chính quy ở trình độ đại học được thiết kế lần đầu vào năm 2007. Chương trình được cập nhật hàng năm ở cấp môn học và được chính sửa theo định kỳ 4 năm một lần vào các năm 2012, 2016, 2020, 2024. Chương trình hiện đang được áp dụng là phiên bản theo chu kỳ 2024-2028, được giảng dạy trong 4.5 năm bao gồm 155 tín chỉ.");
        thongTinChung.setBac("Đại học, Bậc 7/8 đối với đào tạo kỹ sư");
        thongTinChung.setLoaiBang("Kỹ sư");
        thongTinChung.setLoaiHinhDaoTao("Chính quy");
        thongTinChung.setThoiGian("4.5 năm");
        thongTinChung.setSoTinChiToiThieu(155);
        thongTinChung.setKhoaQuanLy("Công nghệ thông tin");
        thongTinChung.setNgonNgu("Tiếng Việt");
        thongTinChung.setWebsite("http://fit.sgu.edu.vn/");
        thongTinChung.setBanHanh("Theo Quyết định số .../.../QĐ-DHSG ngày ... tháng ... năm 2020 của Hiệu trưởng Trường Đại học Sài Gòn");

        thongTinChungRepository.save(thongTinChung);
    }
}