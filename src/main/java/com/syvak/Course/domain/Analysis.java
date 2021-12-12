package com.syvak.Course.domain;

import javax.persistence.*;

@Entity
@Table(name = "analysis")
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String analysis_type_name;
    @Column(name = "labolatory_id")
    private Integer id_labolatory;
    @Column(name = "analysis_type_id")
    private Integer id_analysis_type;
    @Column(name = "patient_ssn")
    private Integer id_patient_ssn;

}