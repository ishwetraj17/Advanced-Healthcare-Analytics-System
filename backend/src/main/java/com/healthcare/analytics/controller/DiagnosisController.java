package com.healthcare.analytics.controller;

import com.healthcare.analytics.model.Diagnosis;
import com.healthcare.analytics.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnoses")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @PostMapping("/add")
    public String addDiagnosis(@RequestBody Diagnosis diagnosis) {
        diagnosisService.addDiagnosis(diagnosis);
        return "Diagnosis added successfully!";
    }

    @GetMapping("/patient/{patientId}")
    public List<Diagnosis> getDiagnosesByPatientId(@PathVariable Long patientId) {
        return diagnosisService.getDiagnosesByPatientId(patientId);
    }
}
