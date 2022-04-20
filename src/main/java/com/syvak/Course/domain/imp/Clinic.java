package com.syvak.Course.domain.imp;

import com.syvak.Course.domain.AbstractModel;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "clinic", schema = "ClinicDB")
public class Clinic implements AbstractModel {
    private Integer id;
    private String clinic_name;
    private Set<Labolatory> labolatory;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinic_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
    public void setLabolatory(Set<Labolatory> labolatory) {
        this.labolatory = labolatory;
    }

    public Set<Labolatory> getLabolatory() {
        return labolatory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return id.equals(clinic.id)
                && clinic_name.equals(clinic.clinic_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clinic_name);
    }


    @Override
    public String toString() {
        return "Clinic{" +
                "clinic_id=" + id +
                ", name='" + clinic_name + '\'' +
                '}';
    }


}
