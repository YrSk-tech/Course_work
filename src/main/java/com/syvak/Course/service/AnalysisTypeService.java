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
    public AnalysisType getById(Integer id) {
        return analysisTypeRepository.getOne(id);
    }

    @Override
    public AnalysisType create(AnalysisType analysisType) {
        return analysisTypeRepository.save(analysisType);
    }

    @Override
    public AnalysisType update(Integer id, AnalysisType analysisType) {
        if (analysisTypeRepository.findById(id).isPresent()) {
            return analysisTypeRepository.save(analysisType);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (analysisTypeRepository.findById(id).isPresent()) {
            analysisTypeRepository.deleteById(id);
        }
    }
}
