package br.com.clinica.api.domain.agenda;


import br.com.clinica.api.domain.agenda.DTOs.DadosAgendamentoDTO;
import br.com.clinica.api.domain.pacientes.Paciente;
import br.com.clinica.api.domain.profissionais.Profissional;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Table(name = "agendamentos")
@Entity(name = "Agendamentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_agendamento")
    @SequenceGenerator(name = "seq_agendamento", sequenceName = "seq_agendamento", initialValue = 1, allocationSize = 1)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profissional")
    private Profissional idProfissional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente idPaciente;

    private LocalDate data;

    private LocalTime hora;

    private Boolean confirmada;

    private String observacao;
}
