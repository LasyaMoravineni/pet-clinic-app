package com.petclinic.pet_clinic_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.petclinic.pet_clinic_app.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
