package br.com.clinica.api.domain.agenda;

import br.com.clinica.api.domain.agenda.DTOs.AgendaDetalheDTO;
import br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO;
import br.com.clinica.api.domain.profissionais.Profissional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    //Busca agendamento por profissiona/data
    @Query("""
            SELECT NEW br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO(ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.data, ag.hora, ag.confirmada) FROM
            Agendamentos ag INNER JOIN Profissionais pr ON
            ag.idProfissional.id = pr.id
            INNER JOIN Pacientes pa ON
            ag.idPaciente.id = pa.id
            WHERE pr.id = :idProfissional and ag.data = :data
            """)
    Page<ListaAgendamentoDTO> findByAgendaProfissional(@Param("idProfissional") Long idProfissional, LocalDate data, Pageable pageable);


    //Busca agendamento por paciente
    @Query("""
            SELECT NEW br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO(ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.data, ag.hora, ag.confirmada) FROM
            Agendamentos ag INNER JOIN Profissionais pr ON
            ag.idProfissional.id = pr.id
            INNER JOIN Pacientes pa ON
            ag.idPaciente.id = pa.id
            WHERE pa.id = :idPaciente and ag.data = :data
            """)
    Page<ListaAgendamentoDTO> findByAgendaPaciente(@Param("idPaciente") Long idPaciente, LocalDate data, Pageable pageable);


    // Consultar agendamentos por data
    @Query("""
            SELECT NEW br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO(ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.data, ag.hora, ag.confirmada) FROM
            Agendamentos ag INNER JOIN Profissionais pr ON
            ag.idProfissional.id = pr.id
            INNER JOIN Pacientes pa ON
            ag.idPaciente.id = pa.id
            WHERE ag.data = :data
            """)
    Page<ListaAgendamentoDTO> findByData(LocalDate data, Pageable pageable);


    @Query("""
            SELECT NEW br.com.clinica.api.domain.agenda.DTOs.AgendaDetalheDTO(ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.data, ag.hora, ag.observacao, ag.confirmada) FROM
            Agendamentos ag INNER JOIN Profissionais pr ON
            ag.idProfissional.id = pr.id
            INNER JOIN Pacientes pa ON
            ag.idPaciente.id = pa.id
            WHERE ag.id = :idAgenda
            """)
    AgendaDetalheDTO findByidAgenda(@Param("idAgenda") Long idAgenda);

}
