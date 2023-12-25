package com.example.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbuseReportService {
    private final AbuseReportRepository abuseReportRepository;


    @Autowired
    public AbuseReportService(AbuseReportRepository abuseReportRepository) {
        this.abuseReportRepository = abuseReportRepository;
    }

    public void saveAbuseReport(AbuseReport abuseReport) {
        abuseReportRepository.save(abuseReport);
    }

    public List<AbuseReport> getAllAbuseReports() {
        return (List<AbuseReport>) abuseReportRepository.findAll();
    }
}
