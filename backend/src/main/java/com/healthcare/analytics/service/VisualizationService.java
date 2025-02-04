package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import com.healthcare.analytics.repository.WearableDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizationService {

    @Autowired
    private WearableDataRepository wearableDataRepository;

    public String getStepTrends(Long patientId) {
        List<WearableData> wearableDataList = wearableDataRepository.findByPatientId(patientId);

        return wearableDataList.stream()
                .map(data -> String.format("Date: %s, Steps: %d", data.getDate(), data.getSteps()))
                .reduce((data1, data2) -> data1 + "\n" + data2)
                .orElse("No data available for this patient.");
    }
}
