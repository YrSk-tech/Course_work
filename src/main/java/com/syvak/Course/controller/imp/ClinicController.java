package com.syvak.Course.controller.imp;


import com.syvak.Course.domain.imp.Clinic;
import com.syvak.Course.service.imp.ClinicService;
import com.syvak.Course.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("clinic")
public class ClinicController extends AbstractControllerImp<Clinic> {
    @Autowired
    ClinicService clinicService;

    @Override
    public final GeneralService<Clinic> getService() {
        return clinicService;
    }


}