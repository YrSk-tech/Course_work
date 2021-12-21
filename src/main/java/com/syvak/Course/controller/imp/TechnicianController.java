package com.syvak.Course.controller.imp;

import com.syvak.Course.domain.imp.Technician;
import com.syvak.Course.service.GeneralService;
import com.syvak.Course.service.imp.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("technician")
@RestController

public class TechnicianController extends AbstractControllerImp<Technician> {
    @Autowired
    TechnicianService technicianService;

    @Override
    public final GeneralService<Technician> getService() {
        return technicianService;
    }
}

