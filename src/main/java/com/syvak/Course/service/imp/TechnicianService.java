package com.syvak.Course.service.imp;


import com.syvak.Course.domain.imp.Technician;
import com.syvak.Course.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TechnicianService extends GeneralServiceImp<Technician> {
    @Autowired
    TechnicianRepository technicianRepository;

    @Override
    public JpaRepository<Technician, Integer> getRepository() {
        return technicianRepository;
    }
}
