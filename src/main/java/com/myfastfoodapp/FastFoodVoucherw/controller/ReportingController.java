package com.myfastfoodapp.FastFoodVoucherw.controller;

import com.myfastfoodapp.FastFoodVoucherw.dto.ReportDTO;
import com.myfastfoodapp.FastFoodVoucherw.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportingController {

	@Autowired
	private ReportService reportService;

	@GetMapping
	public ResponseEntity<List<ReportDTO>> getAllReports() {
    	List<ReportDTO> reports = reportService.getAllReports();
    	return new ResponseEntity<>(reports, HttpStatus.OK

);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReportDTO> getReportById(@PathVariable Long id) {
    	ReportDTO report = reportService.getReportById(id);
    	return new ResponseEntity<>(report, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ReportDTO> createReport(@RequestBody ReportDTO reportDTO) {
    	ReportDTO createdReport = reportService.createReport(reportDTO);
    	return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReportDTO> updateReport(@PathVariable Long id, @RequestBody ReportDTO reportDTO) {
    	ReportDTO updatedReport = reportService.updateReport(id, reportDTO);
    	return new ResponseEntity<>(updatedReport, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
    	reportService.deleteReport(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
