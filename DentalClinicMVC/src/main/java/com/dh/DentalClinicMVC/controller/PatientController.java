package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.DentistService;
import com.dh.DentalClinicMVC.service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController //cuando estamos desarrollando apis, usamos esta anotacion.. no tiene vistas
@RequestMapping("/pacientes")
public class PatientController {

private PatientService patientService;
    // Inyección por Setter
    // Spring utiliza un método setter para inyectar la dependencia.
    // Es útil cuando la dependencia es opcional o debe configurarse después de la construcción del objeto.

    public PatientController(PatientService patientService) {
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

}
