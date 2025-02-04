package com.healthcare.analytics.controller;

import com.healthcare.analytics.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/patient/{patientId}")
    public String getPatientReport(@PathVariable Long patientId) {
        return reportService.generatePatientReport(patientId);
    }

    @GetMapping("/daily")
    public String getDailyReport(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        return reportService.generateDailyReport(localDate);
    }
}
