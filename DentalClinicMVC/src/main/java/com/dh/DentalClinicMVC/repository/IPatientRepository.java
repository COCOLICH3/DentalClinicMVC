package com.dh.DentalClinicMVC.repository;

import com.dh.DentalClinicMVC.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
}
