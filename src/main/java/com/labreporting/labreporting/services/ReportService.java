package com.labreporting.labreporting.services;

import java.util.Date;
import java.io.File;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.lang.reflect.Field;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.labreporting.labreporting.entities.Report;
import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.repositories.ReportRepository;
import com.labreporting.labreporting.responses.ReportResponse;
import com.labreporting.labreporting.vm.ReportCreateVM;
import com.labreporting.labreporting.vm.ReportUpdateRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReportService {

	private ReportRepository reportRepository;
	private UserService userService;

	public ReportService(ReportRepository reportRepository, UserService userService) {
		this.reportRepository = reportRepository;
		this.userService = userService;
	}

	public List<ReportResponse> getAllRaportWithParam(Optional<Long> userId) {
		List<Report> reports;
		if (userId.isPresent()) {
			reports = reportRepository.findByUserUserID(userId.get());
		} else
			reports = reportRepository.findAll();
		return reports.stream().map(comment -> new ReportResponse(comment)).collect(Collectors.toList());
	}

	public Report getOneReportById(Long reportId) {
		return reportRepository.findById(reportId).orElse(null);

	}

	public Report createOneReport(ReportCreateVM create) {
		User user = userService.getByUserId(create.getUserId());
		User user1 = userService.getByUserId(create.getLabId());
		if (user != null) {
			Report reportToSave = new Report();
			reportToSave.setDate(new Date());
			reportToSave.setDetails(create.getDetails());
			reportToSave.setDiagnosis(create.getDiagnosis());
			reportToSave.setUser(user);
			reportToSave.setUser1(user1);
			return reportRepository.save(reportToSave);
		} else {
			return null;
		}
	}

	public Report updateReportByFields(Long reportId, Map<String, Object> fields) {
		Optional<Report> existingReport = reportRepository.findById(reportId);

		if (existingReport.isPresent()) {
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Report.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingReport.get(), value);
			});
			return reportRepository.save(existingReport.get());
		}
		return null;
	}

	public Report updateOneReportById(Long reportId, ReportUpdateRequest request) {
		Optional<Report> report = reportRepository.findById(reportId);
		if (report.isPresent()) {
			Report reportToSave = report.get();
			reportToSave.setDate(request.getDate());
			reportToSave.setDiagnosis(request.getDiagnosis());
			reportToSave.setDetails(request.getDetails());
			return reportRepository.save(reportToSave);

		} else
			return null;
	}

	public void deleteOneReportById(Long reportId) {
		reportRepository.deleteById(reportId);
	}

}
