package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MLService {

    @Autowired
    private AnalyticsService analyticsService;

    public String predictHealthRisk(Long patientId) {
        double averageHeartRate = analyticsService.calculateAverageHeartRate(patientId);

        if (averageHeartRate > 100) {
            return "High risk of cardiovascular issues. Please consult a doctor.";
        } else if (averageHeartRate > 80) {
            return "Moderate risk. Maintain regular exercise and a healthy diet.";
        } else {
            return "Low risk. Keep up with your healthy lifestyle.";
        }
    }
}
