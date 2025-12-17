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

    @PutMapping("/{id}")
    public Owner update(@PathVariable Long id, @RequestBody Owner updatedOwner) {

        Owner existingOwner = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found with id: " + id));

        existingOwner.setName(updatedOwner.getName());
        existingOwner.setEmail(updatedOwner.getEmail());
        existingOwner.setPhone(updatedOwner.getPhone());

        return repo.save(existingOwner);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        if (!repo.existsById(id)) {
            throw new RuntimeException("Owner not found with id: " + id);
        }

        repo.deleteById(id);
        return "Owner deleted successfully with id: " + id;
    }
}