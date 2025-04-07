package org.example.project2.repository;
import org.example.project2.model.ThongTinChung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface ThongTinChungRepository extends JpaRepository<ThongTinChung, Long> {
	@Transactional
    @Modifying
    @Query("DELETE FROM ThongTinChung")
    void deleteAll();
}
