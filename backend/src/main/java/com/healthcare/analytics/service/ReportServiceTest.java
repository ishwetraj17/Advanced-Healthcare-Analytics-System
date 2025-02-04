package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import com.healthcare.analytics.model.Diagnosis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportServiceTest {

    @Mock
    private WearableDataRepository wearableDataRepository;

    @Mock
    private DiagnosisRepository diagnosisRepository;

    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGeneratePatientReport() {
        List<WearableData> wearableDataList = List.of(
            new WearableData(1L, 80, 5000, LocalDate.of(2025, 2, 4))
        );
        List<Diagnosis> diagnosisList = List.of(
            new Diagnosis(1L, "Hypertension", LocalDate.of(2025, 2, 4))
        );

        when(wearableDataRepository.findByPatientId(1L)).thenReturn(wearableDataList);
        when(diagnosisRepository.findByPatientId(1L)).thenReturn(diagnosisList);

        String report = reportService.generatePatientReport(1L);

        String expected = "Patient Report:\n\nWearable Data:\nDate: 2025-02-04, Heart Rate: 80, Steps: 5000\n\nDiagnoses:\nDate: 2025-02-04, Condition: Hypertension";
        assertEquals(expected, report);
    }
}
