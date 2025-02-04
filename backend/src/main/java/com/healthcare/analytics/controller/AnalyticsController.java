package com.healthcare.analytics.controller;

import com.healthcare.analytics.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/average-heart-rate/{patientId}")
    public double getAverageHeartRate(@PathVariable Long patientId) {
        return analyticsService.calculateAverageHeartRate(patientId);
    }

    @GetMapping("/diagnosis-count/{patientId}")
    public long getDiagnosisCount(@PathVariable Long patientId) {
        return analyticsService.countTotalDiagnoses(patientId);
    }
}
