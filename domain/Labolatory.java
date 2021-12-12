package com.syvak.Course.domain;

import javax.persistence.*;

@Entity
@Table(name = "labolatory")
public class Labolatory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labolatory_id")
    private Integer labolatoryId;
    @Column(name = "labolatory_number")
    private Integer labolatoryNumber;
    @ManyToOne
    @JoinColumn(name="clinic_id", nullable=false)
    private Clinic clinic;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "analysis_id", referencedColumnName = "analysis_id")
    private Analysis analysis;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "analysis_type_id", referencedColumnName = "analysis_type_id")
    private AnalysisType analysisType;

    public Labolatory(Integer labolatoryId, Integer labolatoryNumber, Clinic clinic, Analysis analysis, AnalysisType analysisType) {
        this.labolatoryId = labolatoryId;
        this.labolatoryNumber = labolatoryNumber;
        this.clinic = clinic;
        this.analysis = analysis;
        this.analysisType = analysisType;
    }

    public Labolatory(Integer labolatoryNumber, Clinic clinic, Analysis analysis, AnalysisType analysisType) {
        this.labolatoryNumber = labolatoryNumber;
        this.clinic = clinic;
        this.analysis = analysis;
        this.analysisType = analysisType;
    }

    public Integer getLabolatoryId() {
        return labolatoryId;
    }

    public void setLabolatoryId(Integer labolatoryId) {
        this.labolatoryId = labolatoryId;
    }

    public Integer getLabolatoryNumber() {
        return labolatoryNumber;
    }

    public void setLabolatoryNumber(Integer labolatoryNumber) {
        this.labolatoryNumber = labolatoryNumber;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public Labolatory(AnalysisType analysisType) {
        this.analysisType = analysisType;
    }

    @Override
    public String toString() {
        return "Labolatory{" +
                "labolatoryId=" + labolatoryId +
                ", labolatoryNumber=" + labolatoryNumber +
                ", clinic=" + clinic +
                ", analysis=" + analysis +
                ", analysisType=" + analysisType +
                '}';
    }
}