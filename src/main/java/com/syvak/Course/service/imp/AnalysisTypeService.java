package com.syvak.Course.service.imp;


import com.syvak.Course.domain.imp.AnalysisType;
import com.syvak.Course.repository.AnalysisTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AnalysisTypeService extends GeneralServiceImp<AnalysisType> {
    @Autowired
    AnalysisTypeRepository analysisTypeRepository;
    @Override
    public JpaRepository<AnalysisType, Integer> getRepository() {
        return analysisTypeRepository;
    }

}
