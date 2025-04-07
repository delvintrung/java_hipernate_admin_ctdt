package org.example.project2.repository;

import java.util.Optional;

import org.example.project2.model.KhoiKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface KhoiKienThucRepository extends JpaRepository<KhoiKienThuc, Long> {
	Optional<KhoiKienThuc> findByTenKhoi(String tenKhoi);
	@Transactional
    @Modifying
    @Query("DELETE FROM KhoiKienThuc kkt WHERE kkt.khoiCha IS NOT NULL")
    void deleteAllChildren();

    @Transactional
    @Modifying
    @Query("DELETE FROM KhoiKienThuc kkt WHERE kkt.khoiCha IS NULL")
    void deleteAllParents();

    @Transactional
    @Modifying
    @Query("DELETE FROM KhoiKienThuc")
    void deleteAll();
}
