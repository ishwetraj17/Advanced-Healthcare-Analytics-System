package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class DataCorrelationService {

    public String analyzeHeartRateAndSteps(List<WearableData> wearableDataList) {
        if (wearableDataList.isEmpty()) {
            return "No data available for correlation analysis.";
        }

        OptionalDouble averageHeartRate = wearableDataList.stream()
                .filter(data -> data.getHeartRate() != null)
                .mapToInt(WearableData::getHeartRate)
                .average();

        OptionalDouble averageSteps = wearableDataList.stream()
                .filter(data -> data.getSteps() != null)
                .mapToInt(WearableData::getSteps)
                .average();

        if (averageHeartRate.isPresent() && averageSteps.isPresent()) {
            return String.format(
                    "Average Heart Rate: %.2f, Average Steps: %.2f",
                    averageHeartRate.getAsDouble(),
                    averageSteps.getAsDouble()
            );
        }

        return "Incomplete data for correlation analysis.";
    }
}
