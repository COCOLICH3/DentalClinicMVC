package com.dh.DentalClinicMVC.dao;

import com.dh.DentalClinicMVC.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PatientDaoH2 implements IDao<Patient> {

    private static final String SQL_INSERT = "INSERT INTO PATIENTS (NAME, LAST_NAME,EMAIL, CARD_IDENTITY, ADMISSION_OF_DATE, ADDRESS_ID)" +
            " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_ID = "SELECT * FROM PATIENTS WHERE ID = ?";
    private static final String SQL_UPDATE = "UPDATE PATIENTS SET NAME = ?, LAST_NAME = ?, EMAIL=?, CARD_IDENTITY = ?, ADMISSION_OF_DATE = ?," +
            "ADDRESS_ID = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM PATIENTS WHERE ID = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM PATIENTS";
    private static final String SQL_FIND_BY_EMAIL = "SELECT * FROM PATIENTS WHERE EMAIL = ?";
    @Override
    public Patient save(Patient patient) {
        Connection connection = null;

        try {
            AddressDaoH2 addressDaoH2 = new AddressDaoH2();
            addressDaoH2.save(patient.getAddress());

            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getEmail());
            ps.setInt(4, patient.getCardIdentity());
            ps.setDate(5, Date.valueOf(patient.getAdmissionOfDate()));
            ps.setInt(6, patient.getAddress().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                patient.setId(rs.getInt(1));
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return patient;
    }

    @Override
    public Patient findById(Integer id) {

        Connection connection = null;
        Patient patient = new Patient();
        AddressDaoH2 addressDaoH2 = new AddressDaoH2();

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                patient.setId(rs.getInt(1));
                patient.setName(rs.getString(2));
                patient.setLastName(rs.getString(3));
                patient.setEmail(rs.getString(4));//en el video 15 aca le queda otro numero pero no entiendo por que, para mi esta bien asi
                patient.setCardIdentity(rs.getInt(5));
                patient.setAdmissionOfDate(rs.getDate(6).toLocalDate());
                patient.setAddress(addressDaoH2.findById(rs.getInt(7)));
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return patient;
    }

    @Override
    public void update(Patient patient) {

        Connection connection = null;

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getEmail());
            ps.setInt(4, patient.getCardIdentity());
            ps.setDate(5, Date.valueOf(patient.getAdmissionOfDate()));
            ps.setInt(6, patient.getAddress().getId());
            ps.setInt(7, patient.getId());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(Integer id) {

        Connection connection = null;


        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Patient> findAll() {

        Connection connection = null;
        List<Patient> patients = new ArrayList<>();

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt(1));
                patient.setName(rs.getString(2));
                patient.setLastName(rs.getString(3));
                patient.setEmail(rs.getString(4));
                patient.setCardIdentity(rs.getInt(5));
                patient.setAdmissionOfDate(rs.getDate(6).toLocalDate());
                patient.setAddress(new AddressDaoH2().findById(rs.getInt(7)));
                patients.add(patient);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return patients;
    }

    @Override
    public Patient findByString(String value) {

        Connection connection = null;
        Patient patient = new Patient();

        try {
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_BY_EMAIL);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                patient.setId(rs.getInt(1));
                patient.setName(rs.getString(2));
                patient.setLastName(rs.getString(3));
                patient.setEmail(rs.getString(4));
                patient.setCardIdentity(rs.getInt(5));
                patient.setAdmissionOfDate(rs.getDate(6).toLocalDate());
                patient.setAddress(new AddressDaoH2().findById(rs.getInt(7)));

            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return patient;
    }
}
