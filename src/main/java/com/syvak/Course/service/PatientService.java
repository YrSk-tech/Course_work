package com.syvak.Course.service;

import com.syvak.Course.domain.Patient;
import com.syvak.Course.repository.PatientRepository;

import java.util.List;

public class PatientService implements AbstractService<Patient, Integer> {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(Integer id) {
        return patientRepository.getOne(id);
    }

    @Override
    public Patient create(Patient agency) {
        return patientRepository.save(agency);
    }

    @Override
    public Patient update(Integer id, Patient patient) {
        if (patientRepository.findById(id).isPresent()) {
            return patientRepository.save(patient);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (patientRepository.findById(id).isPresent()) {
            patientRepository.deleteById(id);
        }
    }
}