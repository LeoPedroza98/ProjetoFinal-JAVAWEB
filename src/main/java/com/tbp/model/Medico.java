package com.tbp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nome")
    String nome;

    @Column(name = "crm")
    String crm;

    @OneToMany(mappedBy = "medico")
    List<Scheduling> schedulings;

    @ManyToOne
    @JoinColumn(name = "id_specialty")
    Specialty mySpecialty;

    public Specialty getMySpecialty() {
        return mySpecialty;
    }

    public void setMySpecialty(Specialty mySpecialty) {
        this.mySpecialty = mySpecialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Scheduling> getSchedulings() {
        return schedulings;
    }

    public void setSchedulings(List<Scheduling> schedulings) {
        this.schedulings = schedulings;
    }

}
