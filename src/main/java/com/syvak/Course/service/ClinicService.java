package com.syvak.Course.service;

import com.syvak.Course.domain.Clinic;
import com.syvak.Course.repository.ClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClinicService implements AbstractService<Clinic, Integer> {
    private final ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getAll() {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getById(Integer id) {
        return clinicRepository.getOne(id);
    }

    @Override
    public Clinic create(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    @Override
    public Clinic update(Integer id, Clinic clinic) {
        if (clinicRepository.findById(id).isPresent()) {
            return clinicRepository.save(clinic);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (clinicRepository.findById(id).isPresent()) {
            clinicRepository.deleteById(id);
        }
    }
}