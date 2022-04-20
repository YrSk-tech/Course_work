package com.syvak.Course.domain.imp;

import com.syvak.Course.domain.AbstractModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "analysis")
public class Analysis implements AbstractModel {
    private Integer id;
    private String state;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labolatory_id", referencedColumnName = "labolatory_id")
    private Labolatory labolatory;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "analysis_type_id", referencedColumnName = "analysis_type_id")
    private  AnalysisType analysisType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_ssn", referencedColumnName = "patient_ssn")
    private Patient patient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getState(),
                 getLabolatory(), getAnalysisType(), getPatient()
        );
    }

    @Override
    public String toString() {
        return "Analysis{" +
                "analysisId=" + id +
                "state=" + state +
                ", labolatory=" + labolatory +
                ", analysistype=" + analysisType +
                ", patient=" + patient +
                '}';
    }
}