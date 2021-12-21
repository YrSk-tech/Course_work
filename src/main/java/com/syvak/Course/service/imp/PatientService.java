package com.syvak.Course.service.imp;

import com.syvak.Course.domain.imp.Patient;
import com.syvak.Course.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends GeneralServiceImp<Patient> {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public JpaRepository<Patient, Integer> getRepository() {
        return patientRepository;
    }

}