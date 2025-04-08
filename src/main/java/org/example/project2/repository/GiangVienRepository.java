package org.example.project2.repository;

import org.example.project2.model.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface GiangVienRepository extends JpaRepository<GiangVien, Long> {

    Optional<GiangVien> findByTenGiangVien(String tenGiangVien);
    
    List<GiangVien> findByLoaiGiangVien(String loaiGiangVien);

    @Transactional
    @Modifying
    @Query("DELETE FROM GiangVien")
    void deleteAll();
}