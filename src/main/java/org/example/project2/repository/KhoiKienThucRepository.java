package org.example.project2.repository;

import java.util.Optional;

import org.example.project2.model.KhoiKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhoiKienThucRepository extends JpaRepository<KhoiKienThuc, Long> {
	Optional<KhoiKienThuc> findByTenKhoi(String tenKhoi);
}
