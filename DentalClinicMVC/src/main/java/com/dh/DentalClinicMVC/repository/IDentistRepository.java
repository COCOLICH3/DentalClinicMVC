package com.dh.DentalClinicMVC.repository;

import com.dh.DentalClinicMVC.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist,Long> {



}
