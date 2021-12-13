package com.syvak.Course.dto;

public class DiagnosisDto {
    private Integer diagnosisId;
    private String patientAnalysis;

    public DiagnosisDto(Integer diagnosisId, String patientAnalysis) {
        this.diagnosisId = diagnosisId;
        this.patientAnalysis = patientAnalysis;
    }

    public DiagnosisDto(String patientAnalysis) {
        this.patientAnalysis = patientAnalysis;
    }

    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getPatientAnalysis() {
        return patientAnalysis;
    }

    public void setPatientAnalysis(String patientAnalysis) {
        this.patientAnalysis = patientAnalysis;
    }
}
