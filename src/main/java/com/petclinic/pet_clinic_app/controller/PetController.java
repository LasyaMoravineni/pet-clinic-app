package com.petclinic.pet_clinic_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.pet_clinic_app.model.Owner;
import com.petclinic.pet_clinic_app.model.Pet;
import com.petclinic.pet_clinic_app.repository.OwnerRepository;
import com.petclinic.pet_clinic_app.repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetRepository petRepo;
    private final OwnerRepository ownerRepo;

    public PetController(PetRepository petRepo, OwnerRepository ownerRepo) {
        this.petRepo = petRepo;
        this.ownerRepo = ownerRepo;
    }

    @PostMapping
    public Pet create(@RequestBody Pet pet) {
        if (pet.getOwner() != null && pet.getOwner().getId() != null) {
        Owner owner = ownerRepo.findById(pet.getOwner().getId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        pet.setOwner(owner);
    }

    return petRepo.save(pet);
    }

    @GetMapping
    public List<Pet> getAll() {
        return petRepo.findAll();
    }

    @PutMapping("/{id}")
    public Pet update(@PathVariable Long id, @RequestBody Pet updatedPet) {

        Pet existingPet = petRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));

        existingPet.setName(updatedPet.getName());
        existingPet.setType(updatedPet.getType());

        if (updatedPet.getOwner() != null && updatedPet.getOwner().getId() != null) {
            Owner owner = ownerRepo.findById(updatedPet.getOwner().getId())
                    .orElseThrow(() -> new RuntimeException("Owner not found"));
            existingPet.setOwner(owner);
        }

        return petRepo.save(existingPet);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        if (!petRepo.existsById(id)) {
            throw new RuntimeException("Pet not found with id: " + id);
        }

        petRepo.deleteById(id);
        return "Pet deleted successfully with id: " + id;
    }
}
