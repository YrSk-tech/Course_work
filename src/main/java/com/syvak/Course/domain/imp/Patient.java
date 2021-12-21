package com.syvak.Course.domain.imp;

import com.syvak.Course.domain.AbstractModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class Patient implements AbstractModel {
    private Integer id;
    private String name;
    private String surname;
//    @ManyToOne
//    @JoinColumn(name="doctor_id", nullable=false)
//    private Doctor doctor;
//    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Diagnosis diagnosis;
//    @OneToOne(mappedBy = "patient")
//    private Analysis analysis;

    @Id
    @Column(name = "patient_ssn")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//    public Diagnosis getDiagnosis() {
//        return diagnosis;
//    }
//
//    public void setDiagnosis(Diagnosis diagnosis) {
//        this.diagnosis = diagnosis;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getId(), patient.getId()) && Objects.equals(getName(), patient.getName()) && Objects.equals(getSurname(), patient.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientSsnId=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
//                ", doctor=" + doctor +
//                ", diagnosis=" + diagnosis +
                '}';
    }

}
