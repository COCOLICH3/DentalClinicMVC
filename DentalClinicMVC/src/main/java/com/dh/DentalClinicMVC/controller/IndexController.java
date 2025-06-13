package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.DentistService;
import com.dh.DentalClinicMVC.service.PatientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Data
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PatientService patientService;

    // Inyección por Campo (Menos Recomendada)
    // Inyecta directamente la dependencia en un campo.
    // Es simple, pero menos flexible para pruebas y rompe el principio de responsabilidad única.

    @Autowired
    private DentistService dentistService;

    @GetMapping
    public String findPatientByEmail(Model model, @RequestParam("email") String email,
                                     @RequestParam("id") Integer id) {
        Patient patient = patientService.findByEmail(email);
        Dentist dentist = dentistService.findDentistById(id);
        model.addAttribute("patient", patient);
        model.addAttribute("dentist", dentist);
        return "index";
    }


}
