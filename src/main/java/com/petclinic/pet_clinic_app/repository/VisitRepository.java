package com.petclinic.pet_clinic_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petclinic.pet_clinic_app.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

}