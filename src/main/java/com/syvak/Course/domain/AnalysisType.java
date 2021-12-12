package com.syvak.Course.domain;

import javax.persistence.*;

@Entity
@Table(name = "analysis_type")
public class AnalysisType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name_analysis_type;

    public AnalysisType(Integer id, String name) {
        this.id = id;
        this.name_analysis_type = name;
    }
    public AnalysisType(String name) {
        this(null, name);
    }

    public AnalysisType() {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_analysis_type() {
        return name_analysis_type;
    }

    public void setName_analysis_type(String name_analysis_type) {
        this.name_analysis_type = name_analysis_type;
    }
    @Override
    public String toString() {
        return "Analysis Type{" +
                "id=" + id +
                ", name=" + name_analysis_type +
                '}';
    }
}
