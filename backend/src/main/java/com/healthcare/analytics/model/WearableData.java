package com.healthcare.analytics.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wearable_data")
public class WearableData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private Integer heartRate;
    private Integer steps;
    private Integer caloriesBurned;

    // Getters and Setters
}
