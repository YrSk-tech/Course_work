package com.syvak.Course.service;

import com.syvak.Course.domain.Diagnosis;
import com.syvak.Course.repository.DiagnosisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiagnosisService implements AbstractService<Diagnosis, Integer> {
    private final DiagnosisRepository diagnosisRepository;

    public DiagnosisService(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List<Diagnosis> getAll() {
        return diagnosisRepository.findAll();
    }

    @Override
    public Diagnosis getById(Integer diagnosisId) {
        return diagnosisRepository.getOne(diagnosisId);
    }

    @Override
    public Diagnosis create(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis update(Integer diagnosisId, Diagnosis diagnosis) {
        if (diagnosisRepository.findById(diagnosisId).isPresent()) {
            return diagnosisRepository.save(diagnosis);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer diagnosisId) {
        if (diagnosisRepository.findById(diagnosisId).isPresent()) {
            diagnosisRepository.deleteById(diagnosisId);
        }
    }
}