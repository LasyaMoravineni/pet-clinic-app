package com.petclinic.pet_clinic_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Pet Clinic Application is running successfully on AWS EC2!";
    }
}
