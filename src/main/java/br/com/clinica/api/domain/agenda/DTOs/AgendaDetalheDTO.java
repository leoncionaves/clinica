package br.com.clinica.api.domain.agenda.DTOs;

import br.com.clinica.api.domain.agenda.Agendamento;

import java.time.LocalDate;
import java.time.LocalTime;


public record AgendaDetalheDTO(Long id, String profissiona, String paciente, LocalDate data, LocalTime hora, String observacao, Boolean confirmada) {

    public AgendaDetalheDTO(Agendamento agendamento) {
        this(agendamento.getId(),
                agendamento.getIdProfissional().getNome(),
                agendamento.getIdPaciente().getNome(),
                agendamento.getData(),
                agendamento.getHora(),
                agendamento.getObservacao(),
                agendamento.getConfirmada());
    }
}
