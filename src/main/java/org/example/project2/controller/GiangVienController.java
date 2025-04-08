package org.example.project2.controller;

import java.util.List;
import java.util.Map;

import org.example.project2.model.GiangVien;
import org.example.project2.model.User;
import org.example.project2.service.GiangVienService;
import org.example.project2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/giangvien")
public class GiangVienController {
	@Autowired
    private GiangVienService giangVienService;
	
	@Autowired
    private UserService userService;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(GiangVienController.class);
	@GetMapping("/all")
    public ResponseEntity<List<GiangVien>> layTatCaGiangVien() {
        List<GiangVien> giangViens = giangVienService.layTatCaGiangVien();
        return ResponseEntity.ok(giangViens);
    }
	
	@PostMapping
    public ResponseEntity<String> themGiangVien(@RequestBody String requestBody) {
		try {
			Map<String, Object> requestMap = objectMapper.readValue(requestBody, new TypeReference<Map<String, Object>>() {});
			String tenGiangVien = (String) requestMap.get("tenGiangVien");
			String email = (String) requestMap.get("email");
			User newUser =  userService.taoUserMoi(tenGiangVien, email);
			
			GiangVien newGiangVien = new GiangVien();
			newGiangVien.setLoaiGiangVien((String) requestMap.get("loaiGiangVien"));
			newGiangVien.setTenGiangVien(tenGiangVien);
			newGiangVien.setUser(newUser);
			
			giangVienService.themGiangVienTrucTiep(newGiangVien);
			return ResponseEntity.ok(tenGiangVien);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok("Sai");
		}
		//			String requestBodyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(giangVien);
//            logger.info("RequestBody nhận được:\n{}", requestBodyJson);
    }
	
}


