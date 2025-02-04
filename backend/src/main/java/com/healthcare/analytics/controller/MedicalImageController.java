package com.healthcare.analytics.controller;

import com.healthcare.analytics.model.MedicalImage;
import com.healthcare.analytics.service.MedicalImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class MedicalImageController {

    @Autowired
    private MedicalImageService medicalImageService;

    @PostMapping("/add")
    public String addMedicalImage(@RequestBody MedicalImage image) {
        medicalImageService.addMedicalImage(image);
        return "Medical image metadata added successfully!";
    }

    @GetMapping("/patient/{patientId}")
    public List<MedicalImage> getImagesByPatientId(@PathVariable Long patientId) {
        return medicalImageService.getImagesByPatientId(patientId);
    }
}
