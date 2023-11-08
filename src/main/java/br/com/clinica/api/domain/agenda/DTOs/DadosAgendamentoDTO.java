package br.com.clinica.api.domain.agenda.DTOs;

import br.com.clinica.api.domain.agenda.Agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosAgendamentoDTO(Long id, Long idProfissional, Long idPaciente, LocalDate data, LocalTime hora, String observacao, Boolean confirmada) {

    public DadosAgendamentoDTO(Agendamento agendamento) {
        this(agendamento.getId(),
             agendamento.getIdProfissional(),
             agendamento.getIdPaciente(),
             agendamento.getData(),
             agendamento.getHora(),
             agendamento.getObservacao(),
             agendamento.getConfirmada());
    }
}
