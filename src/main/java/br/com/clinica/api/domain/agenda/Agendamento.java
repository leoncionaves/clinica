package br.com.clinica.api.domain.agenda;


import br.com.clinica.api.domain.agenda.DTOs.DadosAgendamentoDTO;
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


    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinTable(name = "profissionais", joinColumns = @JoinColumn(name = "id"))
    //@JoinColumn(name = "idProfissional", nullable = false, referencedColumnName = "id")
    private Long idProfissional;

   // @ManyToOne(fetch = FetchType.EAGER)
    //@JoinTable(name = "pacientes", joinColumns = @JoinColumn(name = "id"))
   // @JoinColumn(name = "idPaciente", nullable = false, referencedColumnName = "id")
    private Long idPaciente;

    private LocalDate data;

    private LocalTime hora;

    private Boolean confirmada;

    private String observacao;


    public Agendamento(DadosAgendamentoDTO dados){
        this.idProfissional = dados.idProfissional();
        this.idPaciente = dados.idPaciente();
        this.data = dados.data();
        this.hora = dados.hora();
        this.observacao = dados.observacao();
        this.confirmada = dados.confirmada();
    }

}
