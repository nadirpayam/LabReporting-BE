package com.labreporting.labreporting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labreporting.labreporting.entities.Report;
import com.labreporting.labreporting.repositories.ReportRepository;
import com.labreporting.labreporting.responses.ReportResponse;
import com.labreporting.labreporting.services.ReportService;
import com.labreporting.labreporting.vm.ReportCreateVM;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
	
	private ReportService reportService;

	public ReportController(ReportService reportService) {
		this.reportService = reportService;
	}
	
	@GetMapping
	public List<ReportResponse> getAllReports(@RequestParam Optional<Long> userId) {
		return reportService.getAllRaportWithParam(userId);
	}
	
	@GetMapping("/{reportId}")
	public Report getOneReport(@PathVariable Long reportId) {
		return reportService.getOneReportById(reportId);
	}
	
	@PostMapping
	public Report createOneBasket(@Valid @RequestBody ReportCreateVM create) {
		return reportService.createOneReport(create);
	}
	
}
