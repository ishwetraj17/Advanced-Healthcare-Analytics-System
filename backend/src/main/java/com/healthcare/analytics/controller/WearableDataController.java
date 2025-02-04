package com.healthcare.analytics.controller;

import com.healthcare.analytics.model.WearableData;
import com.healthcare.analytics.service.WearableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wearable")
public class WearableDataController {

    @Autowired
    private WearableDataService wearableDataService;

    @PostMapping("/add")
    public String addWearableData(@RequestBody WearableData data) {
        wearableDataService.addWearableData(data);
        return "Wearable data added successfully!";
    }

    @GetMapping("/patient/{patientId}")
    public List<WearableData> getDataByPatientId(@PathVariable Long patientId) {
        return wearableDataService.getDataByPatientId(patientId);
    }
}
