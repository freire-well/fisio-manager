package com.fisio.manager.fisio_manager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "prontuarios")
@Getter
@Setter
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", length = 255)
    private String nomeCompleto;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "idade", length = 10)
    private String idade;

    @Column(name = "sexo", length = 20)
    private String sexo;

    @Column(name = "profissao", length = 100)
    private String profissao;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "endereco", columnDefinition = "TEXT")
    private String endereco;

    @Column(name = "antecedentes", columnDefinition = "TEXT")
    private String antecedentes;

    @Column(name = "medicamentos", columnDefinition = "TEXT")
    private String medicamentos;

    @Column(name = "cirurgias", columnDefinition = "TEXT")
    private String cirurgias;

    @Column(name = "queixa_principal", columnDefinition = "TEXT")
    private String queixaPrincipal;

    @Column(name = "inicio_sintomas", length = 255)
    private String inicioSintomas;

    @Column(name = "fatores_agravantes", columnDefinition = "TEXT")
    private String fatoresAgravantes;

    @Column(name = "fatores_atenuantes", columnDefinition = "TEXT")
    private String fatoresAtenuantes;

    @Column(name = "inspecao", columnDefinition = "TEXT")
    private String inspecao;

    @Column(name = "palpacao", columnDefinition = "TEXT")
    private String palpacao;

    @Column(name = "adm", columnDefinition = "TEXT")
    private String adm;

    @Column(name = "forca_muscular", columnDefinition = "TEXT")
    private String forcaMuscular;

    @Column(name = "testes_especiais", columnDefinition = "TEXT")
    private String testesEspeciais;

    @Column(name = "diagnostico", columnDefinition = "TEXT")
    private String diagnostico;

    @Column(name = "objetivos_curto", columnDefinition = "TEXT")
    private String objetivosCurto;

    @Column(name = "objetivos_medio", columnDefinition = "TEXT")
    private String objetivosMedio;

    @Column(name = "objetivos_longo", columnDefinition = "TEXT")
    private String objetivosLongo;

    @Column(name = "condutas", columnDefinition = "TEXT")
    private String condutas;

    @Column(name = "tecnicas", columnDefinition = "TEXT")
    private String tecnicas;

    @Column(name = "exercicios", columnDefinition = "TEXT")
    private String exercicios;

    @Column(name = "orientacoes", columnDefinition = "TEXT")
    private String orientacoes;

    @Column(name = "frequencia", length = 100)
    private String frequencia;


    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Sessoes> sessoes;


    private String patientId;

}