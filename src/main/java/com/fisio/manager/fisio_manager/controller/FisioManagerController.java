package com.fisio.manager.fisio_manager.controller;

import com.fisio.manager.fisio_manager.dto.AgendamentoDTO;
import com.fisio.manager.fisio_manager.entity.Paciente;
import com.fisio.manager.fisio_manager.entity.Sessoes;
import com.fisio.manager.fisio_manager.entity.HorarioBloqueado;
import com.fisio.manager.fisio_manager.repository.PacienteRepository;
import com.fisio.manager.fisio_manager.repository.ProntuarioRepository;
import com.fisio.manager.fisio_manager.repository.HorarioBloqueadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.fisio.manager.fisio_manager.entity.Agendamento;
import com.fisio.manager.fisio_manager.entity.Prontuario;
import com.fisio.manager.fisio_manager.repository.AgendamentoRepository;

import java.beans.Transient;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api")
public class FisioManagerController {
    AgendamentoRepository agendamentoRepository;
    PacienteRepository pacienteRepository;
    ProntuarioRepository prontuarioRepository;
    HorarioBloqueadoRepository horarioBloqueadoRepository;


    public FisioManagerController(AgendamentoRepository agendamentoRepository, PacienteRepository pacienteRepository, ProntuarioRepository prontuarioRepository, HorarioBloqueadoRepository horarioBloqueadoRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.pacienteRepository = pacienteRepository;
        this.prontuarioRepository = prontuarioRepository;
        this.horarioBloqueadoRepository = horarioBloqueadoRepository;
    }


    @GetMapping("/agendamentos")
    public List<AgendamentoDTO> agendamentosString() {
        return agendamentoRepository.findAll().stream().map(AgendamentoDTO::new).toList();
    }



    @Transactional
    @PutMapping("/agendamentos")
    public Agendamento adicionarAgendamento(@RequestBody Agendamento entity) {
        Paciente patient = pacienteRepository.findByCpf(entity.getPaciente().getCpf()).map(
            paciente -> {
                entity.setPaciente(paciente);
                return paciente;
            }
        ).orElse(
               pacienteRepository.save(entity.getPaciente())
        );
        Prontuario prontuary = prontuarioRepository.findById(entity.getPaciente().getProntuario().getId()).map(
                prontuario -> {
                    entity.getPaciente().setProntuario(prontuario);
                    return prontuario;
                }
        ).orElse(
                prontuarioRepository.save(entity.getPaciente().getProntuario())
        );
        entity.setPaciente(patient);
        entity.getPaciente().setProntuario(prontuary);
        return agendamentoRepository.save(entity);
        
    }

    @GetMapping("/agendamentos/{id}")
    public Agendamento buscarAgendamento(@PathVariable Long id) {
        return agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento Não encontrado"));
    }
    

    @DeleteMapping("/agendamentos/{id}")
    public void deletarAgendamento(@PathVariable Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento Não encontrado"));
        agendamentoRepository.delete(agendamento);
    }



    @PostMapping("/agendamentos/{id}")
    public Agendamento atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoDTO agendamento) {
        return agendamentoRepository.findById(id)
                .map(agendamentoExistente -> {
                    agendamentoExistente.setDate(agendamento.date());
                    agendamentoExistente.setTime(agendamento.time());
                    agendamentoExistente.setType(agendamento.type());
                    agendamentoExistente.setPaciente(pacienteRepository.findById(agendamento.paciente_id()).orElseThrow(() -> new RuntimeException("Paciente Não encontrado")));

                    return agendamentoRepository.save(agendamentoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    @GetMapping("/prontuarios/{id}")
    public Prontuario getProntuario(@PathVariable Long id) {
        return prontuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Prontuario Não encontrado"));
    }

     @GetMapping("/prontuarios")
    public List<Prontuario> getProntuario() {
         return prontuarioRepository.findAll();
    }

    @PostMapping("/prontuarios/{id}")
    public Prontuario atualizarProntuario(@PathVariable Long id, @RequestBody Prontuario prontuario) {
        return prontuarioRepository.findById(id)
                .map(prontuarioExistente -> {
                    prontuarioExistente.setNomeCompleto(prontuario.getNomeCompleto());
                    prontuarioExistente.setDataNascimento(prontuario.getDataNascimento());
                    prontuarioExistente.setIdade(prontuario.getIdade());
                    prontuarioExistente.setSexo(prontuario.getSexo());
                    prontuarioExistente.setProfissao(prontuario.getProfissao());
                    prontuarioExistente.setTelefone(prontuario.getTelefone());
                    prontuarioExistente.setEndereco(prontuario.getEndereco());
                    prontuarioExistente.setAntecedentes(prontuario.getAntecedentes());
                    prontuarioExistente.setMedicamentos(prontuario.getMedicamentos());
                    prontuarioExistente.setCirurgias(prontuario.getCirurgias());
                    prontuarioExistente.setQueixaPrincipal(prontuario.getQueixaPrincipal());
                    prontuarioExistente.setInicioSintomas(prontuario.getInicioSintomas());
                    prontuarioExistente.setFatoresAgravantes(prontuario.getFatoresAgravantes());
                    prontuarioExistente.setFatoresAtenuantes(prontuario.getFatoresAtenuantes());
                    prontuarioExistente.setInspecao(prontuario.getInspecao());
                    prontuarioExistente.setPalpacao(prontuario.getPalpacao());
                    prontuarioExistente.setAdm(prontuario.getAdm());
                    prontuarioExistente.setForcaMuscular(prontuario.getForcaMuscular());
                    prontuarioExistente.setTestesEspeciais(prontuario.getTestesEspeciais());
                    prontuarioExistente.setDiagnostico(prontuario.getDiagnostico());
                    prontuarioExistente.setObjetivosCurto(prontuario.getObjetivosCurto());
                    prontuarioExistente.setObjetivosMedio(prontuario.getObjetivosMedio());
                    prontuarioExistente.setObjetivosLongo(prontuario.getObjetivosLongo());
                    prontuarioExistente.setCondutas(prontuario.getCondutas());
                    prontuarioExistente.setTecnicas(prontuario.getTecnicas());
                    prontuarioExistente.setExercicios(prontuario.getExercicios());
                    prontuarioExistente.setOrientacoes(prontuario.getOrientacoes());
                    prontuarioExistente.setFrequencia(prontuario.getFrequencia());

                    // Mesclar as sessões de forma segura
                    if (prontuario.getSessoes() != null) {
                        // Limpar a lista existente e adicionar as novas
                        if (prontuarioExistente.getSessoes() == null) {
                            prontuarioExistente.setSessoes(new java.util.ArrayList<>());
                        }
                        prontuarioExistente.getSessoes().clear();
                        for (Sessoes sessao : prontuario.getSessoes()) {
                            sessao.setProntuario(prontuarioExistente);
                            prontuarioExistente.getSessoes().add(sessao);
                        }
                    }

                    return prontuarioRepository.save(prontuarioExistente);
                })
                .orElseThrow(() -> new RuntimeException("Prontuario não encontrado"));
    }


    @PutMapping("/prontuarios/")
    public void adicionarProntuario(@RequestBody Prontuario prontuario) {
        if (prontuario.getSessoes() == null) {
            prontuario.setSessoes(new java.util.ArrayList<>());
        }
        prontuario.getSessoes().forEach(sessao -> sessao.setProntuario(prontuario));
        Paciente paciente = pacienteRepository.findById(Long.valueOf(prontuario.getPatientId())).orElseThrow(() -> new RuntimeException("Paciente Não encontrado"));
        paciente.setProntuario(prontuario);
        prontuarioRepository.save(prontuario);
        pacienteRepository.save(paciente);

    }

    @GetMapping("/pacientes")
    public List<Paciente> pacientesString() {
        return pacienteRepository.findAll();
    }

    @PutMapping("/pacientes")
    public Paciente adicionarPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // ========== HORÁRIOS BLOQUEADOS ==========

    @GetMapping("/horarios-bloqueados")
    public List<HorarioBloqueado> obterHorariosBloqueados() {
        return horarioBloqueadoRepository.findAll();
    }

    @GetMapping("/horarios-bloqueados/{date}")
    public List<HorarioBloqueado> obterHorariosBloqueadosPorData(@PathVariable String date) {
        return horarioBloqueadoRepository.findByDate(date);
    }

    @PostMapping("/horarios-bloqueados")
    public HorarioBloqueado bloquearHorario(@RequestBody HorarioBloqueado horarioBloqueado) {
        return horarioBloqueadoRepository.save(horarioBloqueado);
    }

    @DeleteMapping("/horarios-bloqueados/{id}")
    public void desbloquearHorario(@PathVariable Long id) {
        horarioBloqueadoRepository.deleteById(id);
    }

}
