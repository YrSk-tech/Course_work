package com.syvak.Course.controller.imp;

import com.syvak.Course.domain.imp.Diagnosis;
import com.syvak.Course.service.GeneralService;
import com.syvak.Course.service.imp.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("diagnosis")
public class DiagnosisController extends AbstractControllerImp<Diagnosis> {

    @Autowired
    DiagnosisService diagnosisService;


    @Override
    public final GeneralService<Diagnosis> getService() {
        return diagnosisService;
    }

}

