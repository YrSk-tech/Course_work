package com.syvak.Course.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinic_id")
    private Integer clinic_id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "clinic")
    private Set<Labolatory> labolatory;

    public Clinic(Integer clinic_id, String name, Set<Labolatory> labolatory) {
        this.clinic_id = clinic_id;
        this.name = name;
        this.labolatory = labolatory;
    }

    public Clinic(String name, Set<Labolatory> labolatory) {
        this.name = name;
        this.labolatory = labolatory;
    }


    public Clinic() {
    }


    public Integer getClinic_id() {
        return clinic_id;
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
                "clinic_id=" + clinic_id +
                ", name='" + name + '\'' +
                ", labolatory=" + labolatory +
                '}';
    }
}
