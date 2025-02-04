package com.healthcare.analytics.repository;

import com.healthcare.analytics.model.WearableData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WearableDataRepository extends JpaRepository<WearableData, Long> {
    List<WearableData> findByPatientId(Long patientId);
}
