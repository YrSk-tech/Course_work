package com.syvak.Course.service.imp;

import com.syvak.Course.domain.imp.Analysis;
import com.syvak.Course.repository.AnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService extends GeneralServiceImp<Analysis> {
    @Autowired
    AnalysisRepository analysisRepository;
    @Override
    public JpaRepository<Analysis, Integer> getRepository() {
        return analysisRepository;
    }

}
