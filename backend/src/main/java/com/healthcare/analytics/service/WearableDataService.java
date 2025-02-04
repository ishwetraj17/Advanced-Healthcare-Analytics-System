package com.healthcare.analytics.service;

import com.healthcare.analytics.model.WearableData;
import com.healthcare.analytics.repository.WearableDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WearableDataService {

    @Autowired
    private WearableDataRepository wearableDataRepository;

    public WearableData addWearableData(WearableData data) {
        return wearableDataRepository.save(data);
    }

    public List<WearableData> getDataByPatientId(Long patientId) {
        return wearableDataRepository.findByPatientId(patientId);
    }
}
