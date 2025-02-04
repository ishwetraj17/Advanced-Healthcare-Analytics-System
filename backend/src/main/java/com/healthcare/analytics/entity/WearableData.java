package com.healthcare.analytics.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class WearableData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private int heartRate;
    private int steps;
    private LocalDate date;

    // Getters and setters
}
