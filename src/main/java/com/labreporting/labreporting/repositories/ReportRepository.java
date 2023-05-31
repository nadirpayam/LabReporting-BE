package com.labreporting.labreporting.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labreporting.labreporting.entities.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

	List<Report> findByUserUserID(Long userId);

}
