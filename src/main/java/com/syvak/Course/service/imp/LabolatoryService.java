package com.syvak.Course.service.imp;

import com.syvak.Course.domain.imp.Labolatory;
import com.syvak.Course.repository.LabolatoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LabolatoryService extends GeneralServiceImp<Labolatory> {
    @Autowired
    LabolatoryRepository labolatoryRepository;

    @Override
    public JpaRepository<Labolatory, Integer> getRepository() {
        return labolatoryRepository;
    }

}