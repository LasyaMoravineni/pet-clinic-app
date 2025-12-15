package com.petclinic.pet_clinic_app.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.petclinic.pet_clinic_app.model.Visit;
import com.petclinic.pet_clinic_app.repository.VisitRepository;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitRepository repo;

    public VisitController(VisitRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Visit create(@RequestBody Visit visit) {
        return repo.save(visit);
    }

    @GetMapping
    public List<Visit> getAll() {
        return repo.findAll();
    }
}
