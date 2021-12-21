package com.syvak.Course.controller.imp;

import com.syvak.Course.domain.imp.Patient;
import com.syvak.Course.service.GeneralService;
import com.syvak.Course.service.imp.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("patient")
@RestController
public class PatientController extends AbstractControllerImp<Patient> {
    @Autowired
    PatientService patientService;

    @Override
    public final GeneralService<Patient> getService() {
        return patientService;
    }
}
