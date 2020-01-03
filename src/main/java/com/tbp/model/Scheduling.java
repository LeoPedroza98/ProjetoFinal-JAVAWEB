package com.tbp.model;

import javafx.scene.control.DatePicker;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "scheduling")
public class Scheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Temporal(TemporalType.DATE)
    @Column(name ="data")
    Date dataScheduling;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_person")
    Person person;

    @Transient
    String dataFormatada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataScheduling() {
        return dataScheduling;
    }

    public void setDataScheduling(Date dataScheduling) {
        this.dataScheduling = dataScheduling;
        configDataFormatada();
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDataFormatada() {
        configDataFormatada();
        return dataFormatada;
    }

    private String configDataFormatada() {
        if(dataScheduling != null) {
            SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
            dataFormatada = s.format(dataScheduling);
            return dataFormatada;
        }
        return "";
    }
}
