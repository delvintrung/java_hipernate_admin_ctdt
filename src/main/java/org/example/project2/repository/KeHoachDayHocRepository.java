package org.example.project2.repository;

import org.example.project2.model.KeHoachDayHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface KeHoachDayHocRepository extends JpaRepository<KeHoachDayHoc, Long> {

    Optional<KeHoachDayHoc> findByHocPhanMaHocPhan(Long maHocPhan);

    @Transactional
    @Modifying
    @Query("DELETE FROM KeHoachDayHoc")
    void deleteAll();
}