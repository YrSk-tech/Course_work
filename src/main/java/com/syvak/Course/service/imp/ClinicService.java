package com.syvak.Course.service.imp;

import com.syvak.Course.domain.imp.Clinic;
import com.syvak.Course.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClinicService extends GeneralServiceImp<Clinic> {
    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public JpaRepository<Clinic, Integer> getRepository() {
        return clinicRepository;
    }


}