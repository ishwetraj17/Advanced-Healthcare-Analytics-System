package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import com.healthcare.analytics.model.Diagnosis;
import com.healthcare.analytics.repository.WearableDataRepository;
import com.healthcare.analytics.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private WearableDataRepository wearableDataRepository;

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public String generatePatientReport(Long patientId) {
        List<WearableData> wearableDataList = wearableDataRepository.findByPatientId(patientId);
        List<Diagnosis> diagnosisList = diagnosisRepository.findByPatientId(patientId);

        String wearableSummary = wearableDataList.stream()
                .map(data -> String.format("Date: %s, Heart Rate: %d, Steps: %d",
                        data.getDate(), data.getHeartRate(), data.getSteps()))
                .collect(Collectors.joining("\n"));

        String diagnosisSummary = diagnosisList.stream()
                .map(diagnosis -> String.format("Date: %s, Condition: %s",
                        diagnosis.getDate(), diagnosis.getCondition()))
                .collect(Collectors.joining("\n"));

        return String.format("Patient Report:\n\nWearable Data:\n%s\n\nDiagnoses:\n%s",
                wearableSummary, diagnosisSummary);
    }

    public String generateDailyReport(LocalDate date) {
        List<WearableData> dataForDate = wearableDataRepository.findByDate(date);

        String summary = dataForDate.stream()
                .map(data -> String.format("Patient ID: %d, Heart Rate: %d, Steps: %d",
                        data.getPatientId(), data.getHeartRate(), data.getSteps()))
                .collect(Collectors.joining("\n"));

        return String.format("Daily Report for %s:\n\n%s", date, summary);
    }
}
