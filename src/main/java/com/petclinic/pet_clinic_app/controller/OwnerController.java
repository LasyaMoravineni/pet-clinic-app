package com.petclinic.pet_clinic_app.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.petclinic.pet_clinic_app.model.Owner;
import com.petclinic.pet_clinic_app.repository.OwnerRepository;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerRepository repo;

    public OwnerController(OwnerRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Owner create(@RequestBody Owner owner) {
        return repo.save(owner);
    }

    @GetMapping
    public List<Owner> getAll() {
        return repo.findAll();
    }
}