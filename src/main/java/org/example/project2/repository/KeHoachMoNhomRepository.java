	package org.example.project2.repository;

import java.util.List;
import java.util.Optional;

import org.example.project2.model.KeHoachDayHoc;
import org.example.project2.model.KeHoachMoNhom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeHoachMoNhomRepository extends JpaRepository<KeHoachMoNhom, Long> {
	
	List findAll();
}
