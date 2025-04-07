package org.example.project2.repository;

import org.example.project2.model.KeHoachMoNhom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface KeHoachMoNhomRepository extends JpaRepository<KeHoachMoNhom, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM KeHoachMoNhom")
    void deleteAll();
}