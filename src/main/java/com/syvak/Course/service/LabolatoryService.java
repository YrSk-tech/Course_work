package com.syvak.Course.service;

import com.syvak.Course.domain.Labolatory;
import com.syvak.Course.repository.LabolatoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabolatoryService implements AbstractService<Labolatory, Integer> {
    private final LabolatoryRepository labolatoryRepository;

    public LabolatoryService(LabolatoryRepository labolatoryRepository) {
        this.labolatoryRepository = labolatoryRepository;
    }

    @Override
    public List<Labolatory> getAll() {
        return labolatoryRepository.findAll();
    }

    @Override
    public Labolatory getById(Integer id) {
        return labolatoryRepository.getOne(id);
    }

    @Override
    public Labolatory create(Labolatory labolatory) {
        return labolatoryRepository.save(labolatory);
    }

    @Override
    public Labolatory update(Integer id, Labolatory labolatory) {
        if (labolatoryRepository.findById(id).isPresent()) {
            return labolatoryRepository.save(labolatory);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (labolatoryRepository.findById(id).isPresent()) {
            labolatoryRepository.deleteById(id);
        }
    }
}