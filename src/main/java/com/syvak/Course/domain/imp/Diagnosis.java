package com.syvak.Course.domain.imp;

import com.syvak.Course.domain.AbstractModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "diagnosis")
public class Diagnosis implements AbstractModel {
    private Integer id;

    private String patientAnalysis;

//    private Patient patient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosis_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "patient_analysis")
    public String getPatientAnalysis() {
        return patientAnalysis;
    }

    public void setPatientAnalysis(String patientAnalysis) {
        this.patientAnalysis = patientAnalysis;
    }
    //    @OneToOne
//    @MapsId
//    @JoinColumn(name = "patient_ssn")
//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnosis)) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return getId().equals(diagnosis.getId()) && getPatientAnalysis().equals(diagnosis.getPatientAnalysis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPatientAnalysis());
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisId=" + id +
                ", patientAnalysis='" + patientAnalysis + '\'' +
//                ", patient=" + patient +
                '}';
    }
}
