package com.syvak.Course.dto;

public class ClinicDto {
    private Integer clinicId;
    private String name;

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClinicDto(Integer clinicId, String name) {
        this.clinicId = clinicId;
        this.name = name;
    }

    public ClinicDto(String name) {
        this.name = name;
    }
}

