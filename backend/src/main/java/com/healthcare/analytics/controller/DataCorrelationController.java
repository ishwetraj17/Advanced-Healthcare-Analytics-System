package com.healthcare.analytics.controller;

import com.healthcare.analytics.model.WearableData;
import com.healthcare.analytics.service.DataCorrelationService;
import com.healthcare.analytics.service.WearableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data-correlation")
public class DataCorrelationController {

    @Autowired
    private DataCorrelationService dataCorrelationService;

    @Autowired
    private WearableDataService wearableDataService;

    @GetMapping("/analyze/{patientId}")
    public String analyzeHeartRateAndSteps(@PathVariable Long patientId) {
        List<WearableData> wearableDataList = wearableDataService.getDataByPatientId(patientId);
        return dataCorrelationService.analyzeHeartRateAndSteps(wearableDataList);
    }
}
