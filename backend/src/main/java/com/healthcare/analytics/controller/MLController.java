package com.healthcare.analytics.controller;

import com.healthcare.analytics.service.MLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ml")
public class MLController {

    @Autowired
    private MLService mlService;

    @GetMapping("/predict-health-risk/{patientId}")
    public String predictHealthRisk(@PathVariable Long patientId) {
        return mlService.predictHealthRisk(patientId);
    }
}
