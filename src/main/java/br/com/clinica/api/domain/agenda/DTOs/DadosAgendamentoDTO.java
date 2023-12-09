package br.com.clinica.api.domain.agenda.DTOs;

import br.com.clinica.api.domain.agenda.Agendamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosAgendamentoDTO(Long id,
                                  @NotNull
                                  Long idProfissional,
                                  @NotNull
                                  Long idPaciente,

                                  @NotNull
                                  @JsonFormat(pattern = "dd/MM/yyyy")
                                  LocalDate data,
                                  @NotNull
                                  @JsonFormat(pattern = "HH:MM")
                                  LocalTime hora,
                                  String observacao,
                                  @NotNull
                                  Boolean confirmada) {}
