package com.healthcare.analytics.service;

import com.healthcare.analytics.model.Patient;
import com.healthcare.analytics.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getPatientsByUserId(Long userId) {
        return patientRepository.findByUserId(userId);
    }
}
