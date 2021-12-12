package com.syvak.Course.service;


import com.syvak.Course.domain.Doctor;
import com.syvak.Course.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService implements AbstractService<Doctor, Integer> {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getById(Integer id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Integer id, Doctor doctor) {
        if (doctorRepository.findById(id).isPresent()) {
            return doctorRepository.save(doctor);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (doctorRepository.findById(id).isPresent()) {
            doctorRepository.deleteById(id);
        }
    }
}
