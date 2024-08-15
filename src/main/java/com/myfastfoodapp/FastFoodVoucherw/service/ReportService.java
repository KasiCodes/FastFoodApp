package com.myfastfoodapp.FastFoodVoucherw.service;

import com.myfastfoodapp.FastFoodVoucherw.dto.ReportDTO;

import java.util.List;

public interface ReportService {
	List<ReportDTO> getAllReports();
	ReportDTO getReportById(Long id);
	ReportDTO createReport(ReportDTO reportDTO);
	ReportDTO updateReport(Long id, ReportDTO reportDTO);
	void deleteReport(Long id);
}
