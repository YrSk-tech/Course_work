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

    public Labolatory(Integer labolatoryId, Integer labolatoryNumber, Clinic clinic) {
        this.labolatoryId = labolatoryId;
        this.labolatoryNumber = labolatoryNumber;
        this.clinic = clinic;
    }

    public Labolatory(Integer labolatoryNumber, Clinic clinic) {
        this.labolatoryNumber = labolatoryNumber;
        this.clinic = clinic;
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

    @Override
    public String toString() {
        return "Labolatory{" +
                "labolatoryId=" + labolatoryId +
                ", labolatory Number=" + labolatoryNumber +
                ", clinic=" + clinic +
                '}';
    }
}