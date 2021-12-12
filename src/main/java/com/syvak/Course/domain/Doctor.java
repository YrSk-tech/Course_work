package com.syvak.Course.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "clinic_name")
    private String clinicName;
    @OneToMany(mappedBy = "doctor")
    private Set<Patient> patient;

    public Doctor(Integer doctorId, String name, String surname, String clinicName, Set<Patient> patient) {
        this.doctorId = doctorId;
        this.name = name;
        this.surname = surname;
        this.clinicName = clinicName;
        this.patient = patient;
    }

    public Doctor(String name, String surname, String clinicName, Set<Patient> patient) {
        this.name = name;
        this.surname = surname;
        this.clinicName = clinicName;
        this.patient = patient;
    }

    public Doctor() {
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public Set<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Set<Patient> patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor id=" + doctorId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", clinic name='" + clinicName + '\'' +
                ", patient=" + patient +
                '}';
    }
}
