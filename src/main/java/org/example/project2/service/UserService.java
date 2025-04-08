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
        themHoacCapNhatUser("Nguyễn Văn A", "nguyenvana@example.com", "GIANG_VIEN");
        // Thêm user 2
        themHoacCapNhatUser("Trần Thị B", "tranthib@example.com", "GIANG_VIEN");
        // Thêm user 3
        themHoacCapNhatUser("Lê Văn C", "levanc@example.com", "GIANG_VIEN");
        // Thêm user 4
        themHoacCapNhatUser("Phạm Thị D", "phamthid@example.com", "GIANG_VIEN");
        // Thêm user 5
        themHoacCapNhatUser("Hoàng Văn E", "hoangvane@example.com", "GIANG_VIEN");
    }

    private void themHoacCapNhatUser(String tenUser, String email, String vaiTro) {
        // Kiểm tra xem user đã tồn tại chưa (dựa trên email)
        Optional<User> existingUser = userRepository.findById(
                userRepository.findAll().stream()
                        .filter(user -> user.getEmail() != null && user.getEmail().equals(email))
                        .map(User::getMaUser)
                        .findFirst()
                        .orElse(null)
        );
        User user;

        if (existingUser.isPresent()) {
            // Nếu đã tồn tại, cập nhật
            user = existingUser.get();
        } else {
            // Nếu chưa tồn tại, tạo mới
            user = new User();
        }

        // Cập nhật thông tin
        user.setTenUser(tenUser);
        user.setEmail(email);
        user.setVaiTro(vaiTro);

        // Lưu hoặc cập nhật
        userRepository.save(user);
    }

    
    @Transactional
    public User taoUserMoi(String tenUser, String email) {
        User user = new User();
        user.setTenUser(tenUser);
        user.setEmail(email);
        user.setVaiTro("GIANG_VIEN");
        return userRepository.save(user);
    }

    @Transactional
    public void deleteAll() {
        userRepository.deleteAll();
    }
}