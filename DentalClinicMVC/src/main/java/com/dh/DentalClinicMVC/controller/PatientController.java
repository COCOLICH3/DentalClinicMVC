package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.IPatientService;
import com.dh.DentalClinicMVC.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //cuando estamos desarrollando apis, usamos esta anotacion.. no tiene vistas
@RequestMapping("/pacientes")
public class PatientController {

private IPatientService patientService;
    // Inyección por Setter
    // Spring utiliza un método setter para inyectar la dependencia.
    // Es útil cuando la dependencia es opcional o debe configurarse después de la construcción del objeto.

    @Autowired
    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @PutMapping
    public void update(@RequestBody Patient patient){
        patientService.update(patient);
    }

    @GetMapping
    public List<Patient> getAll(){
        return patientService.findAll();
    }

}
