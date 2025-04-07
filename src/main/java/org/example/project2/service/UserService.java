package org.example.project2.service;

import org.example.project2.model.User;
import org.example.project2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void themUser() {
        // Thêm user 1
    	themHoacCapNhatUser(1, "Nguyễn Văn A");
        // Thêm user 2
        themHoacCapNhatUser(2, "Trần Thị B");
        // Thêm user 3
        themHoacCapNhatUser(3, "Lê Văn C");
        // Thêm user 4
        themHoacCapNhatUser(4, "Phạm Thị D");
        // Thêm user 5
        themHoacCapNhatUser(5, "Hoàng Văn E");
    }

    private void themHoacCapNhatUser(Integer maUser, String tenUser) {
        // Kiểm tra xem user đã tồn tại chưa
        Optional<User> existingUser = userRepository.findById(maUser);
        User user;

        if (existingUser.isPresent()) {
            // Nếu đã tồn tại, cập nhật
            user = existingUser.get();
        } else {
            // Nếu chưa tồn tại, tạo mới
            user = new User();
            user.setMaUser(maUser);
        }

        // Cập nhật thông tin
        user.setTenUser(tenUser);

        // Lưu hoặc cập nhật
        userRepository.save(user);
    }

    @Transactional
    public void deleteAll() {
        userRepository.deleteAll();
    }
}