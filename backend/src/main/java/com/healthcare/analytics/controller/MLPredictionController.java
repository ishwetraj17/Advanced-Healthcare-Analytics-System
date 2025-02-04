package com.healthcare.analytics.controller;

import com.healthcare.analytics.model.WearableData;
import com.healthcare.analytics.service.MLPredictionService;
import com.healthcare.analytics.service.WearableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ml-prediction")
public class MLPredictionController {

    @Autowired
    private MLPredictionService mlPredictionService;

    @Autowired
    private WearableDataService wearableDataService;

    @GetMapping("/predict-risk/{patientId}")
    public String predictHealthRisk(@PathVariable Long patientId) {
        List<WearableData> wearableDataList = wearableDataService.getDataByPatientId(patientId);
        return mlPredictionService.predictRiskLevel(wearableDataList);
    }
}
