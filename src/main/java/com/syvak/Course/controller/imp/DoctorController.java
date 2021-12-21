package com.syvak.Course.controller.imp;

import com.syvak.Course.domain.imp.Doctor;
import com.syvak.Course.service.GeneralService;
import com.syvak.Course.service.imp.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("doctor")
@RestController
public class DoctorController extends AbstractControllerImp<Doctor> {
    @Autowired
    DoctorService doctorService;

    @Override
    public final GeneralService<Doctor> getService() {
        return doctorService;
    }


}