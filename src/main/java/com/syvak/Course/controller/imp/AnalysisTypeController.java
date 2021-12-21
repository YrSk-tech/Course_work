package com.syvak.Course.controller.imp;

import com.syvak.Course.domain.imp.AnalysisType;
import com.syvak.Course.service.GeneralService;
import com.syvak.Course.service.imp.AnalysisTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analysis_type")
public class AnalysisTypeController extends AbstractControllerImp<AnalysisType> {
    @Autowired
    AnalysisTypeService analysisTypeService;

    @Override
    public final GeneralService<AnalysisType> getService() {
        return analysisTypeService;
    }


}