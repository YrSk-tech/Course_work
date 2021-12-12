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

    public Patient(Integer patientSsnId, String name, String surname, Doctor doctor) {
        this.patientSsnId = patientSsnId;
        this.name = name;
        this.surname = surname;
        this.doctor = doctor;
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

    @Override
    public String toString() {
        return "Patient{" +
                "patient ssn =" + patientSsnId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
