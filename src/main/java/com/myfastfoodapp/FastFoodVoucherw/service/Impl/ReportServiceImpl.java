package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import com.myfastfoodapp.FastFoodVoucherw.dto.ReportDTO;
import com.myfastfoodapp.FastFoodVoucherw.model.Report;
import com.myfastfoodapp.FastFoodVoucherw.repository.ReportRepository;
import com.myfastfoodapp.FastFoodVoucherw.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Override
	public List<ReportDTO> getAllReports() {
    	return reportRepository.findAll().stream()
            	.map(this::convertToDTO)
            	.collect(Collectors.toList());
	}

	@Override
	public ReportDTO getReportById(Long id) {
    	Report report = reportRepository.findById(id)
            	.orElseThrow(() -> new RuntimeException("Report not found"));
    	return convertToDTO(report);
	}

	@Override
	public ReportDTO createReport(ReportDTO reportDTO) {
    	Report report = convertToEntity(reportDTO);
    	Report savedReport = reportRepository.save(report);
    	return convertToDTO(savedReport);
	}

	@Override
	public ReportDTO updateReport(Long id, ReportDTO reportDTO) {
    	Report report = reportRepository.findById(id)
            	.orElseThrow(() -> new RuntimeException("Report not found"));
    	report.setTitle(reportDTO.getTitle());
    	report.setContent(reportDTO.getContent());
    	Report updatedReport = reportRepository.save(report);
    	return convertToDTO(updatedReport);
	}

	@Override
	public void deleteReport(Long id) {
    	if (!reportRepository.existsById(id)) {
        	throw new RuntimeException("Report not found");
    	}
    	reportRepository.deleteById(id);
	}

	private ReportDTO convertToDTO(Report report) {
    	return new ReportDTO(report.getId(), report.getTitle(), report.getContent());
	}

	private Report convertToEntity(ReportDTO reportDTO) {
    	return new Report(reportDTO.getId(), reportDTO.getTitle(), reportDTO.getContent());
	}
}
