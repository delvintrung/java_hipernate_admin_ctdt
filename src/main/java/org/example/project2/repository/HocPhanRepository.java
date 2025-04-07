package org.example.project2.repository;

import org.example.project2.model.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface HocPhanRepository extends JpaRepository<HocPhan, Long> {
	@Transactional
    @Modifying
    @Query("DELETE FROM HocPhan")
    void deleteAll();
}
