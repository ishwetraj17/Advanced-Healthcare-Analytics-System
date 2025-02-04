package com.healthcare.analytics.service;

import com.healthcare.analytics.model.MedicalImage;
import com.healthcare.analytics.repository.MedicalImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalImageService {

    @Autowired
    private MedicalImageRepository medicalImageRepository;

    public MedicalImage addMedicalImage(MedicalImage image) {
        return medicalImageRepository.save(image);
    }

    public List<MedicalImage> getImagesByPatientId(Long patientId) {
        return medicalImageRepository.findByPatientId(patientId);
    }
}
