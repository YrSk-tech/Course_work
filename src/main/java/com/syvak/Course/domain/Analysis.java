package com.syvak.Course.domain;

import javax.persistence.*;

@Entity
@Table(name = "analysis")
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_id")
    private Integer analysisId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labolatory_id", referencedColumnName = "labolatory_id")
    private Labolatory labolatory;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "analysis_type_id", referencedColumnName = "analysis_type_id")
    private  AnalysisType analysisType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    public Analysis(Integer analysisId, Labolatory labolatory, AnalysisType analysisType, Patient patient) {
        this.analysisId = analysisId;
        this.labolatory = labolatory;
        this.analysisType = analysisType;
        this.patient = patient;
    }

    public Analysis(Labolatory labolatory, AnalysisType analysisType, Patient patient) {
        this.labolatory = labolatory;
        this.analysisType = analysisType;
        this.patient = patient;
    }

    public Integer getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Integer analysisId) {
        this.analysisId = analysisId;
    }

    public Labolatory getLabolatory() {
        return labolatory;
    }

    public void setLabolatory(Labolatory labolatory) {
        this.labolatory = labolatory;
    }

    public AnalysisType getAnalysisType() {
        return analysisType;
    }

    public void setAnalysisType(AnalysisType analysisType) {
        this.analysisType = analysisType;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "analysisId=" + analysisId +
                ", labolatory=" + labolatory +
                ", analysistype=" + analysisType +
                ", patient=" + patient +
                '}';
    }
}