package com.dh.DentalClinicMVC.dao;

import com.dh.DentalClinicMVC.model.Appointment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppointmentDaoList implements IDao<Appointment> {

    private List<Appointment> appointments;

    public AppointmentDaoList() {
        appointments = new ArrayList<>();
    }

    @Override
    public Appointment save(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public Appointment findById(Integer id) {
        Appointment appointmentToLookFor = null;
        for (Appointment appointment : appointments) {
            if (Objects.equals(appointment.getId(), id)) {
                appointmentToLookFor = appointment;
                return appointmentToLookFor;
            }
        }
        return appointmentToLookFor;
    }

    @Override
    public void update(Appointment appointment) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Appointment> findAll() {
        return appointments;
    }

    @Override
    public Appointment findByString(String value) {
        return null;
    }
}
