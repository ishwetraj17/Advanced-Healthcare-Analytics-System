package com.healthcare.analytics.controller;

import com.healthcare.analytics.model.Patient;
import com.healthcare.analytics.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return "Patient added successfully!";
    }

    @GetMapping("/user/{userId}")
    public List<Patient> getPatientsByUserId(@PathVariable Long userId) {
        return patientService.getPatientsByUserId(userId);
    }
}
