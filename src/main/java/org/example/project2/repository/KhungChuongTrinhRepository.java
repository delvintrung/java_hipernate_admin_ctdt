package org.example.project2.repository;
import org.example.project2.model.KhungChuongTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface KhungChuongTrinhRepository extends JpaRepository<KhungChuongTrinh, Long> {
	@Transactional
    @Modifying
    @Query("DELETE FROM KhungChuongTrinh")
    void deleteAll();
}
