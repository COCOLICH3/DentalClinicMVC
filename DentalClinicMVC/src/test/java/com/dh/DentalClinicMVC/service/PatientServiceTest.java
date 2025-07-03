package com.dh.DentalClinicMVC.service;

import com.dh.DentalClinicMVC.model.Patient;
import com.dh.DentalClinicMVC.service.impl.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {

    @Autowired //se usa asi por q la clase test es muy chica
    private PatientService patientService;

    @Test
    void findById() {
        Long id = 1L;
        Optional<Patient> patientFound = patientService.findById(id);
        assertNotNull(patientFound);

    }
}