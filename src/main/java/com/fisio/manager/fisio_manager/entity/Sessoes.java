package com.fisio.manager.fisio_manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@Entity(name = "sessoes")
public class Sessoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    @JsonBackReference
    private Prontuario prontuario;

    @Column(name = "data")
    private String data;

    @Column(name = "horario")
    private String horario;

    @Column(name = "procedimentos", columnDefinition = "TEXT")
    private String procedimentos;

    @Column(name = "evolucao", columnDefinition = "TEXT")
    private String evolucao;

    @Column(name = "valor")
    private String valor;

    @Column(name = "pagamento")
    private String pagamento;

}
