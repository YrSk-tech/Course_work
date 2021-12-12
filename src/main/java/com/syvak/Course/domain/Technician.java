package com.syvak.Course.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "technician")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technician_id")
    private Integer technicianId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @ManyToOne
    @JoinColumn(name="labolatory_id", nullable=false)
    private Set<Labolatory> Labolatory;

    public Technician(Integer technicianId, String name, String surname, Set<com.syvak.Course.domain.Labolatory> labolatory) {
        this.technicianId = technicianId;
        this.name = name;
        this.surname = surname;
        Labolatory = labolatory;
    }

    public Technician(String name, String surname, Set<com.syvak.Course.domain.Labolatory> labolatory) {
        this.name = name;
        this.surname = surname;
        Labolatory = labolatory;
    }

    public Technician() {
    }

    public Integer getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Integer technicianId) {
        this.technicianId = technicianId;
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

    public Set<com.syvak.Course.domain.Labolatory> getLabolatory() {
        return Labolatory;
    }

    public void setLabolatory(Set<com.syvak.Course.domain.Labolatory> labolatory) {
        Labolatory = labolatory;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "technicianId=" + technicianId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", Labolatory=" + Labolatory +
                '}';
    }
}