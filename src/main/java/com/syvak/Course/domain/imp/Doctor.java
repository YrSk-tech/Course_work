package com.syvak.Course.domain.imp;

import com.syvak.Course.domain.AbstractModel;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor implements AbstractModel {
    private Integer id;
    private String name;
    private String surname;
    private String clinicName;
//    @OneToMany(mappedBy = "doctor")
//    private Set<Patient> patient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
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
    @Basic
    @Column(name = "clinic_name")
    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

//    public Set<Patient> getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Set<Patient> patient) {
//        this.patient = patient;
//    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", clinic name='" + clinicName + '\'' +
//                ", patient=" + patient +
                '}';
    }
}
