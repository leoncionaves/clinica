package br.com.clinica.api.domain.agenda.DTOs;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(of = "id")
public class AgendaDetalheDTO {

    private Long id;
    private String profissional;
    private String paciente;
    private LocalDate data;
    private LocalTime hora;
    private String observacao;
    private Boolean confirmada;

    public AgendaDetalheDTO(Long id, String profissiona, String paciente, LocalDate data, LocalTime hora, String observacao, Boolean confirmada) {
        this.id = id;
        this.profissional = profissiona;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
        this.confirmada = confirmada;
    }
}
