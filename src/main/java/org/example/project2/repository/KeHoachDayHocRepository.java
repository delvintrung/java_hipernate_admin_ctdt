package org.example.project2.repository;

import java.util.Optional;

import org.example.project2.model.KeHoachDayHoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeHoachDayHocRepository extends JpaRepository<KeHoachDayHoc, Long> {
	Optional<KeHoachDayHoc> findByHocPhanMaHocPhan(Long maHocPhan);
}
