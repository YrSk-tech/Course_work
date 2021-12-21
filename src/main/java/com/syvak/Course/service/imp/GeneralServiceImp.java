package com.syvak.Course.service.imp;

import com.syvak.Course.service.GeneralService;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

public abstract class GeneralServiceImp<E> implements GeneralService<E> {
    @Override
    public List<E> findAll() {
        List<E> es = new LinkedList<>(getRepository().findAll());
        if (es.isEmpty()) {
            return null;
        }
        return es;
    }

    @Override
    public E find(Integer id) {
        if (getRepository().findById(id).isPresent()) {
            return getRepository().findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void create(E e) {
        if (e != null) {
            getRepository().save(e);
        }
    }

    @Override
    @Transactional
    public void update(E e) {
        getRepository().save(e);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (getRepository().findById(id).isPresent()) {
            getRepository().deleteById(id);
        }
    }
}
