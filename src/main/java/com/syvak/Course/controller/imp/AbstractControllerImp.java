package com.syvak.Course.controller.imp;

import com.syvak.Course.controller.AbstractController;
import com.syvak.Course.domain.AbstractModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractControllerImp<E extends AbstractModel> implements AbstractController<E> {


    @Override
    @GetMapping("")
    public List<E> findAll() {
        return getService().findAll();
    }

    @Override
    @GetMapping("/{id}")
    public E findById(@PathVariable Integer id) {
        return getService().find(id);
    }

    @Override
    @PostMapping("")
    public void create(@RequestBody E t) {
        getService().create(t);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody E t) {
        t.setId(id);
        getService().update(t);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        getService().delete(id);
    }
}
