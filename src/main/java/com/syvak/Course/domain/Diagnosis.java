package com.syvak.Course.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosis_id")
    private Integer diagnosisId;
    @Column(name = "patient_analysis")
    private String patientAnalysis;
    @OneToOne
    @MapsId
    @JoinColumn(name = "patient_ssn")
    private Patient patient;

    public Diagnosis(Integer diagnosisId, String patientAnalysis, Patient patient) {
        this.diagnosisId = diagnosisId;
        this.patientAnalysis = patientAnalysis;
        this.patient = patient;
    }

    public Diagnosis(Integer diagnosisId, String patientAnalysis) {
        this.diagnosisId = diagnosisId;
        this.patientAnalysis = patientAnalysis;
    }

    public Diagnosis() {
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisId=" + diagnosisId +
                ", patientAnalysis='" + patientAnalysis + '\'' +
                ", patient=" + patient +
                '}';
    }
}
