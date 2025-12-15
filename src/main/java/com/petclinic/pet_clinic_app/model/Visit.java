package com.petclinic.pet_clinic_app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate visitDate;
    private double consultationFee;

    @ManyToOne
    private Pet pet;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }
}
