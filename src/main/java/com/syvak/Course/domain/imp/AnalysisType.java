package com.syvak.Course.domain.imp;

import com.syvak.Course.domain.AbstractModel;

import javax.persistence.*;

@Entity
@Table(name = "analysis_type")
public class AnalysisType implements AbstractModel {
    private Integer id;
    private String type;
//    @OneToOne(mappedBy = "analysisType")
//    private Analysis analysis;
//    @OneToOne(mappedBy = "analysisType")
//    private Labolatory labolatory;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_type_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AnalysisType{" +
                "analysisTypeId=" + id +
                ", type='" + type + '\'' +
//                ", analysis=" + analysis +
//                ", labolatory=" + labolatory +
                '}';
    }
}
