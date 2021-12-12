package com.syvak.Course.domain;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "patient_ssn")
    private Integer patientSsnId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctor doctor;
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Diagnosis diagnosis;
    @OneToOne(mappedBy = "patient")
    private Analysis analysis;

    public Patient(Integer patientSsnId, String name, String surname, Doctor doctor, Diagnosis diagnosis) {
        this.patientSsnId = patientSsnId;
        this.name = name;
        this.surname = surname;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
    }

    public Patient(String name, String surname, Doctor doctor, Diagnosis diagnosis) {
        this.name = name;
        this.surname = surname;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
    }

    public Patient() {
    }

    public Integer getPatientSsnId() {
        return patientSsnId;
    }

    public void setPatientSsnId(Integer patientSsnId) {
        this.patientSsnId = patientSsnId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientSsnId=" + patientSsnId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", doctor=" + doctor +
                ", diagnosis=" + diagnosis +
                '}';
    }
}
