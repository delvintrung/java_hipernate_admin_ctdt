package org.example.project2.controller;

import java.util.List;

import org.example.project2.model.ThongTinChung;
import org.example.project2.service.ThongTinChungService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/thongtinchung")
public class ThongTinChungController {
	@Autowired
    private ThongTinChungService thongTinChungService;
	
	private static final Logger logger = LoggerFactory.getLogger(ThongTinChungController.class);

    @GetMapping("/")
    public ResponseEntity<List<ThongTinChung>> layTatCaThongTinChung() {
        try {
            List<ThongTinChung> thongTinChungList = thongTinChungService.layTatCaThongTinChung();
            return ResponseEntity.ok(thongTinChungList);
        } catch (Exception e) {
            logger.error("Lỗi khi lấy tất cả thông tin chung: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }
    
    

    @PostMapping("/greet")
    public String greet(@RequestBody Greeting greeting) {
        return "Xin chào, " + greeting.getName();
    }

    static class Greeting {
        private String name;

        // getter + setter
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}

