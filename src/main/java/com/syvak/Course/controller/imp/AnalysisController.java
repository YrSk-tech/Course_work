package com.syvak.Course.controller.imp;

import com.syvak.Course.domain.imp.Analysis;
import com.syvak.Course.service.GeneralService;
import com.syvak.Course.service.imp.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analysis")
public class AnalysisController extends AbstractControllerImp<Analysis> {
    @Autowired
    AnalysisService analysisService;

    @Override
    public final GeneralService<Analysis> getService() {
        return analysisService;
    }


}