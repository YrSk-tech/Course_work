package com.syvak.Course.controller.imp;


import com.syvak.Course.domain.imp.Labolatory;
import com.syvak.Course.service.GeneralService;

import com.syvak.Course.service.imp.LabolatoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("labolatory")
@RestController
public class LabolatoryController extends AbstractControllerImp<Labolatory>{
    @Autowired
    LabolatoryService labolatoryService;

    @Override
    public final GeneralService<Labolatory> getService() {
        return labolatoryService;
    }

}

