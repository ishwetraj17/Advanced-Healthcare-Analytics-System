package com.healthcare.analytics.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String condition;
    private LocalDate date;

    // Getters and setters
}
