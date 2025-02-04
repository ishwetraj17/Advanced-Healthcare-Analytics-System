package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MLPredictionServiceTest {

    private MLPredictionService mlPredictionService;

    @BeforeEach
    public void setUp() {
        mlPredictionService = new MLPredictionService();
    }

    @Test
    public void testPredictRiskLevelHigh() {
        List<WearableData> wearableDataList = List.of(
            new WearableData(1L, 120, 10000, "2025-02-04")
        );
        String result = mlPredictionService.predictRiskLevel(wearableDataList);
        assertEquals("High risk of cardiovascular complications.", result);
    }

    @Test
    public void testPredictRiskLevelLow() {
        List<WearableData> wearableDataList = List.of(
            new WearableData(1L, 70, 5000, "2025-02-04")
        );
        String result = mlPredictionService.predictRiskLevel(wearableDataList);
        assertEquals("Low risk. Keep up the good work!", result);
    }
}
