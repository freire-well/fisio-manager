package com.fisio.manager.fisio_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisio.manager.fisio_manager.entity.Paciente;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByCpf(String cpf);}
