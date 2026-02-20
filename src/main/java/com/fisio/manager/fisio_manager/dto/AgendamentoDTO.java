package com.fisio.manager.fisio_manager.dto;

import com.fisio.manager.fisio_manager.entity.Agendamento;

public record AgendamentoDTO(
        Long id,
        String date,
        String time,
        String type,
        Long paciente_id
) {
    public AgendamentoDTO(Agendamento a) {
        this(a.getId(), a.getDate(), a.getTime(),
                a.getType(), a.getPaciente().getId());
    }
}
