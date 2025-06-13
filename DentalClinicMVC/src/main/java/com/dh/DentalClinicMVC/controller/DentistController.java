package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.service.DentistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class DentistController {

    private DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/{id}")
    public Dentist findById(@PathVariable Integer id) {
        return dentistService.findDentistById(id);
    }

    @PostMapping
    public Dentist createDentist(@RequestBody Dentist dentist) {
        return dentistService.save(dentist);
    }

    @PutMapping
    public void updateDentist(@RequestBody Dentist dentist) {
        dentistService.updateDentist(dentist);
    }

    @DeleteMapping("/{id}")
    public void deleteDentist(@PathVariable Integer id) {
        dentistService.deleteDentist(id);
    }

    @GetMapping
    public List<Dentist> findAll() {
        return dentistService.findAllDentist();
    }
}
