package com.syvak.Course.controller;


import com.syvak.Course.domain.Clinic;
import com.syvak.Course.dto.ClinicDto;
import com.syvak.Course.service.ClinicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/clinic")
@RestController
public class ClinicController {
    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicsService) {
        this.clinicService = clinicsService;
    }

    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<ClinicDto>> getAll() {
        List<Clinic> clinics = clinicService.getAll();
        List<ClinicDto> clinicsDtos = new ArrayList<>();
        for (Clinic clinic : clinics) {
            ClinicDto clinicDto = new ClinicDto(
                    clinic.getClinicId(),
                    clinic.getName()
            );
            clinicsDtos.add(clinicDto);
        }
        return new ResponseEntity<>(clinicsDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ClinicDto> getById(@PathVariable Integer id) {
        Clinic clinic = clinicService.getById(id);
        if (clinic != null) {
            ClinicDto clinicDtos = new ClinicDto(
                    clinic.getClinicId(),
                    clinic.getName()
            );
            return new ResponseEntity<>(clinicDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Clinic newClinics) {
        clinicService.create(newClinics);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClinicDto> update(@PathVariable Integer id,
                                            @RequestBody Clinic award) {
        Clinic clinicOld = clinicService.getById(id);
        if (clinicOld != null) {
            award.setClinicId(id);
            clinicService.update(id, award);
            ClinicDto awardOldDto = new ClinicDto(
                    clinicOld.getClinicId(),
                    clinicOld.getName()
            );
            return new ResponseEntity<>(awardOldDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (clinicService.getById(id) != null) {
            clinicService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}