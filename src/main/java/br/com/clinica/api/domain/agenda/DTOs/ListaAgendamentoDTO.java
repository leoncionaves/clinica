package br.com.clinica.api.domain.agenda.DTOs;

import br.com.clinica.api.domain.agenda.Agendamento;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(of = "id")
public class ListaAgendamentoDTO {


    private Long id;
    private String profissional;
    private String paciente;
    private LocalDate data;
    private LocalTime hora;
    private Boolean confirmada;

    public ListaAgendamentoDTO(Long id, String profissiona, String paciente, LocalDate data, LocalTime hora, Boolean confirmada) {
        this.id = id;
        this.profissional = profissiona;
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
        this.confirmada = confirmada;
    }
}
