package com.syvak.Course.controller;

import com.syvak.Course.domain.Diagnosis;
import com.syvak.Course.dto.DiagnosisDto;
import com.syvak.Course.service.DiagnosisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/diagnosis")
@RestController
public class DiagnosisController {
    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<DiagnosisDto>> getAll() {
        List<Diagnosis> diagnosis = diagnosisService.getAll();
        List<DiagnosisDto> diagnosisDtos = new ArrayList<>();
        for (Diagnosis reaction : diagnosis) {
            DiagnosisDto diagnosisDto = new DiagnosisDto(
                    reaction.getDiagnosisId(),
                    reaction.getPatientAnalysis()
            );
            diagnosisDtos.add(diagnosisDto);
        }
        return new ResponseEntity<>(diagnosisDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<DiagnosisDto> getById(@PathVariable Integer diagnosisId) {
        Diagnosis reaction = diagnosisService.getById(diagnosisId);
        if (reaction != null) {
            DiagnosisDto diagnosisDto = new DiagnosisDto(
                    reaction.getDiagnosisId(),
                    reaction.getPatientAnalysis()
            );
            return new ResponseEntity<>(diagnosisDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Diagnosis newDiagnosis) {
        diagnosisService.create(newDiagnosis);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiagnosisDto> update(@PathVariable Integer id,
                                            @RequestBody Diagnosis diagnosis) {
        Diagnosis diagnosisOld = diagnosisService.getById(id);
        if (diagnosisOld != null) {
            diagnosisService.update(id, diagnosis);
            DiagnosisDto reactionsOldDto = new DiagnosisDto(
                    diagnosisOld.getDiagnosisId(),
                    diagnosisOld.getPatientAnalysis()
            );
            return new ResponseEntity<>(reactionsOldDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (diagnosisService.getById(id) != null) {
            diagnosisService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

