package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import com.healthcare.analytics.model.Diagnosis;
import com.healthcare.analytics.repository.WearableDataRepository;
import com.healthcare.analytics.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private WearableDataRepository wearableDataRepository;

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public double calculateAverageHeartRate(Long patientId) {
        List<WearableData> dataList = wearableDataRepository.findByPatientId(patientId);
        if (dataList.isEmpty()) return 0.0;

        return dataList.stream()
                .filter(data -> data.getHeartRate() != null)
                .mapToInt(WearableData::getHeartRate)
                .average()
                .orElse(0.0);
    }

    public long countTotalDiagnoses(Long patientId) {
        return diagnosisRepository.findByPatientId(patientId).size();
    }
}
