package com.fisio.manager.fisio_manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
public class Agendamento {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Paciente paciente;
    private String date;
    private String time;
    private String type;
}
