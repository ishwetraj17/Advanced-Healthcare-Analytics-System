package com.healthcare.analytics.controller;

import com.healthcare.analytics.service.VisualizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visualization")
public class VisualizationController {

    @Autowired
    private VisualizationService visualizationService;

    @GetMapping("/steps-trend/{patientId}")
    public String getStepTrends(@PathVariable Long patientId) {
        return visualizationService.getStepTrends(patientId);
    }
}
