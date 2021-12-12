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
    public Diagnosis getById(Integer id) {
        return diagnosisRepository.getOne(id);
    }

    @Override
    public Diagnosis create(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis update(Integer id, Diagnosis diagnosis) {
        if (diagnosisRepository.findById(id).isPresent()) {
            return diagnosisRepository.save(diagnosis);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (diagnosisRepository.findById(id).isPresent()) {
            diagnosisRepository.deleteById(id);
        }
    }
}