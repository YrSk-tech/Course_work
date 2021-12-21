package com.syvak.Course.domain.imp;

import com.syvak.Course.domain.AbstractModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "labolatory")
public class Labolatory implements AbstractModel {

    private Integer id;

    private Integer labolatoryNumber;
//    @ManyToOne
//    @JoinColumn(name="clinic_id", nullable=false)
//    private Clinic clinic;
//    @OneToOne(mappedBy = "labolatory")
//    private Analysis analysis;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "analysis_type_id", referencedColumnName = "analysis_type_id")
//       private AnalysisType analysisType;
//    @OneToMany(mappedBy="labolatory")
//    private Set<Technician> technician;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "labolatory_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "labolatory_number")
    public Integer getLabolatoryNumber() {
        return labolatoryNumber;
    }

    public void setLabolatoryNumber(Integer labolatoryNumber) {
        this.labolatoryNumber = labolatoryNumber;
    }

//    public Clinic getClinic() {
//        return clinic;
//    }
//
//    public void setClinic(Clinic clinic) {
//        this.clinic = clinic;
//    }

//    public Analysis getAnalysis() {
//        return analysis;
//    }
//
//    public void setAnalysis(Analysis analysis) {
//        this.analysis = analysis;
//    }
//
//    public Labolatory(AnalysisType analysisType) {
//        this.analysisType = analysisType;
//    }
//
//    public Set<Technician> getTechnician() {
//        return technician;
//    }
//
//    public void setTechnician(Set<Technician> technician) {
//        this.technician = technician;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Labolatory)) return false;
        Labolatory that = (Labolatory) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getLabolatoryNumber(), that.getLabolatoryNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLabolatoryNumber());
    }

    @Override
    public String toString() {
        return "Labolatory{" +
                "labolatoryId=" + id +
                ", labolatoryNumber=" + labolatoryNumber +
//                ", clinic=" + clinic +
//                ", analysis=" + analysis +
//                ", analysisType=" + analysisType +
                '}';
    }
}