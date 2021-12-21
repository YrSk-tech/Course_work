package com.syvak.Course.service;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface GeneralService<E> {
    JpaRepository<E, Integer> getRepository();
    List<E> findAll();
    E find(Integer id);
    @Transactional
    void create(E t);
    @Transactional
    void update(E t);
    @Transactional
    void delete(Integer id);
}
