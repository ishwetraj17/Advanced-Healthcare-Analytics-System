package com.healthcare.analytics.repository;

import com.healthcare.analytics.model.MedicalImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalImageRepository extends JpaRepository<MedicalImage, Long> {
    List<MedicalImage> findByPatientId(Long patientId);
}
