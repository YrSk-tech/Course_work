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
    public Doctor getById(Integer doctorId) {
        return doctorRepository.getOne(doctorId);
    }

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Integer doctorId, Doctor doctor) {
        if (doctorRepository.findById(doctorId).isPresent()) {
            return doctorRepository.save(doctor);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer doctorId) {
        if (doctorRepository.findById(doctorId).isPresent()) {
            doctorRepository.deleteById(doctorId);
        }
    }
}
