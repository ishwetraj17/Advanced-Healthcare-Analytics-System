package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MLPredictionService {

    public String predictRiskLevel(List<WearableData> wearableDataList) {
        if (wearableDataList.isEmpty()) {
            return "No data available for prediction.";
        }

        double averageHeartRate = wearableDataList.stream()
                .filter(data -> data.getHeartRate() != null)
                .mapToInt(WearableData::getHeartRate)
                .average()
                .orElse(0.0);

        if (averageHeartRate > 100) {
            return "High risk of cardiovascular complications.";
        } else if (averageHeartRate > 80) {
            return "Moderate risk. Maintain a healthy lifestyle.";
        } else {
            return "Low risk. Keep up the good work!";
        }
    }
}
