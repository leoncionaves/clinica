package br.com.clinica.api.domain.agenda.DTOs;

import br.com.clinica.api.domain.agenda.Agendamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;


public record AgendaDetalheDTO(Long id, String profissiona, String paciente, LocalDate data, LocalTime hora, String observacao, Boolean confirmada) {

    public AgendaDetalheDTO(Agendamento agendamento) {
        this(agendamento.getId(),
                agendamento.getIdProfissional().getPessoa().getNome(),
                agendamento.getIdPaciente().getPessoa().getNome(),
                agendamento.getData(),
                agendamento.getHora(),
                agendamento.getObservacao(),
                agendamento.getConfirmada());
    }
}
