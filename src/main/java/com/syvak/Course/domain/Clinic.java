package com.syvak.Course.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinic_id")
    private Integer clinicId;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "clinic")
    private Set<Labolatory> labolatory;

    public Clinic(Integer clinicId, String name, Set<Labolatory> labolatory) {
        this.clinicId = clinicId;
        this.name = name;
        this.labolatory = labolatory;
    }

    public Clinic(String name, Set<Labolatory> labolatory) {
        this.name = name;
        this.labolatory = labolatory;
    }


    public Clinic() {
    }


    public Integer getClinicId() {
        return clinicId;
    }


    public String getName() {
        return name;
    }

    public Set<Labolatory> getLabolatory() {
        return labolatory;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "clinic_id=" + clinicId +
                ", name='" + name + '\'' +
                ", labolatory=" + labolatory +
                '}';
    }
}
