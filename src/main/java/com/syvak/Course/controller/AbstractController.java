package com.syvak.Course.controller;

import com.syvak.Course.service.GeneralService;

import java.util.List;

public interface AbstractController<E> {
    GeneralService<E> getService();
    List<E> findAll();
    E findById(Integer id);
    void create(E e);
    void update(Integer id, E e);

    void delete(Integer id);
}
