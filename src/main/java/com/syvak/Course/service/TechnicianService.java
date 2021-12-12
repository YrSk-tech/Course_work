package com.syvak.Course.service;


import com.syvak.Course.domain.Technician;
import com.syvak.Course.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnicianService implements AbstractService<Technician, Integer> {
    private final TechnicianRepository technicianRepository;

    public TechnicianService(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @Override
    public List<Technician> getAll() {
        return technicianRepository.findAll();
    }

    @Override
    public Technician getById(Integer id) {
        return technicianRepository.getOne(id);
    }

    @Override
    public Technician create(Technician technician) {
        return technicianRepository.save(technician);
    }

    @Override
    public Technician update(Integer id, Technician technician) {
        if (technicianRepository.findById(id).isPresent()) {
            return technicianRepository.save(technician);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (technicianRepository.findById(id).isPresent()) {
            technicianRepository.deleteById(id);
        }
    }
}
