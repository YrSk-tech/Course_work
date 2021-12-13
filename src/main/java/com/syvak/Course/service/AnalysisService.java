package com.syvak.Course.service;

import com.syvak.Course.domain.Analysis;
import com.syvak.Course.repository.AnalysisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisService implements AbstractService<Analysis, Integer> {
    private final AnalysisRepository analysisRepository;

    public AnalysisService(AnalysisRepository analysisRepository) {
        this.analysisRepository = analysisRepository;
    }

    @Override
    public List<Analysis> getAll() {
        return analysisRepository.findAll();
    }

    @Override
    public Analysis getById(Integer analysisId) {
        return analysisRepository.getOne(analysisId);
    }

    @Override
    public Analysis create(Analysis analysis) {
        return analysisRepository.save(analysis);
    }

    @Override
    public Analysis update(Integer analysisId, Analysis analysis) {
        if (analysisRepository.findById(analysisId).isPresent()) {
            return analysisRepository.save(analysis);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer analysisId) {
        if (analysisRepository.findById(analysisId).isPresent()) {
            analysisRepository.deleteById(analysisId);
        }
    }
}
