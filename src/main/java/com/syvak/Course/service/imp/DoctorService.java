package com.syvak.Course.service.imp;


import com.syvak.Course.domain.imp.Doctor;
import com.syvak.Course.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends GeneralServiceImp<Doctor> {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public JpaRepository<Doctor, Integer> getRepository() {
        return doctorRepository;
    }

}
