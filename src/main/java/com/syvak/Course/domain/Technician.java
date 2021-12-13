package com.syvak.Course.domain;

import javax.persistence.*;

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
    private Labolatory labolatory;

    public Technician(Integer technicianId, String name, String surname, Labolatory labolatory) {
        this.technicianId = technicianId;
        this.name = name;
        this.surname = surname;
        labolatory = labolatory;
    }

    public Technician(String name, String surname, Labolatory labolatory) {
        this.name = name;
        this.surname = surname;
        labolatory = labolatory;
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

    public Labolatory getLabolatory() {
        return labolatory;
    }

    public void setLabolatory(Labolatory labolatory) {
        labolatory = labolatory;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "technicianId=" + technicianId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", Labolatory=" + labolatory +
                '}';
    }
}