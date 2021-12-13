package com.syvak.Course.service;


import com.syvak.Course.domain.AnalysisType;
import com.syvak.Course.repository.AnalysisTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisTypeService implements AbstractService<AnalysisType, Integer> {
    private final AnalysisTypeRepository analysisTypeRepository;

    public AnalysisTypeService(AnalysisTypeRepository analysisTypeRepository) {
        this.analysisTypeRepository = analysisTypeRepository;
    }

    @Override
    public List<AnalysisType> getAll() {
        return analysisTypeRepository.findAll();
    }

    @Override
    public AnalysisType getById(Integer analysisTypeId) {
        return analysisTypeRepository.getOne(analysisTypeId);
    }

    @Override
    public AnalysisType create(AnalysisType analysisType) {
        return analysisTypeRepository.save(analysisType);
    }

    @Override
    public AnalysisType update(Integer analysisTypeId, AnalysisType analysisType) {
        if (analysisTypeRepository.findById(analysisTypeId).isPresent()) {
            return analysisTypeRepository.save(analysisType);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer analysisTypeId) {
        if (analysisTypeRepository.findById(analysisTypeId).isPresent()) {
            analysisTypeRepository.deleteById(analysisTypeId);
        }
    }
}
