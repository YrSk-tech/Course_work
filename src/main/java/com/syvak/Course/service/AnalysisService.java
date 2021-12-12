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
    public Analysis getById(Integer id) {
        return analysisRepository.getOne(id);
    }

    @Override
    public Analysis create(Analysis analysis) {
        return analysisRepository.save(analysis);
    }

    @Override
    public Analysis update(Integer id, Analysis analysis) {
        if (analysisRepository.findById(id).isPresent()) {
            return analysisRepository.save(analysis);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (analysisRepository.findById(id).isPresent()) {
            analysisRepository.deleteById(id);
        }
    }
}
