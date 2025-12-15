package com.petclinic.pet_clinic_app.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.petclinic.pet_clinic_app.model.Pet;
import com.petclinic.pet_clinic_app.repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetRepository repo;

    public PetController(PetRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Pet create(@RequestBody Pet pet) {
        return repo.save(pet);
    }

    @GetMapping
    public List<Pet> getAll() {
        return repo.findAll();
    }
}
