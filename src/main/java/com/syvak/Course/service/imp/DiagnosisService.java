package com.syvak.Course.service.imp;


import com.syvak.Course.domain.imp.Diagnosis;
import com.syvak.Course.repository.DiagnosisRepository;
import com.syvak.Course.service.imp.GeneralServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiagnosisService extends GeneralServiceImp<Diagnosis> {
    @Autowired
    DiagnosisRepository diagnosisRepository;

    @Override
    public JpaRepository<Diagnosis, Integer> getRepository() {
        return diagnosisRepository;
    }
}