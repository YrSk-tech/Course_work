package com.syvak.Course.domain;

import javax.persistence.*;

@Entity
@Table(name = "analysis_type")
public class AnalysisType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_type_id")
    private Integer analysisTypeId;
    @Column(name = "type")
    private String type;
    @OneToOne(mappedBy = "analysis")
    private Analysis analysis;
    @OneToOne(mappedBy = "analysis_type")
    private Labolatory labolatory;

    public AnalysisType(Integer analysisTypeId, String type) {
        this.analysisTypeId = analysisTypeId;
        this.type = type;
    }

    public AnalysisType(String type) {
        this.type = type;
    }

    public AnalysisType() {
    }

    public Integer getAnalysisTypeId() {
        return analysisTypeId;
    }

    public void setAnalysisTypeId(Integer analysisTypeId) {
        this.analysisTypeId = analysisTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AnalysisType{" +
                "analysisTypeId=" + analysisTypeId +
                ", type='" + type + '\'' +
                ", analysis=" + analysis +
                ", labolatory=" + labolatory +
                '}';
    }
}
