package com.syvak.Course.domain.imp;

import com.syvak.Course.domain.AbstractModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "technician")
public class Technician implements AbstractModel {
    private Integer id;
    private String name;
    private String surname;
//    @ManyToOne
//    @JoinColumn(name="labolatory_id", nullable=false)
//    private Labolatory labolatory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technician_id")
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

//    public Labolatory getLabolatory() {
//        return labolatory;
//    }
//
//    public void setLabolatory(Labolatory labolatory) {
//        labolatory = labolatory;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technician)) return false;
        Technician that = (Technician) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getSurname().equals(that.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname());
    }

    @Override
    public String toString() {
        return "Technician{" +
                "technicianId=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
//                ", Labolatory=" + labolatory +
                '}';
    }
}