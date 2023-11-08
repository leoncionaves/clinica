package br.com.clinica.api.domain.agenda;

import br.com.clinica.api.domain.agenda.DTOs.AgendaDetalheDTO;
import br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AgendamentoRepository extends JpaRepository <Agendamento, Long> {

    //Busca agendamento por profissiona/data
    @Query("SELECT NEW br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO(ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.data, ag.hora, ag.confirmada) FROM \n" +
            "Agendamentos ag INNER JOIN Profissionais pr ON\n" +
            "ag.idProfissional = pr.id \n" +
            "INNER JOIN Pacientes pa ON\n" +
            "ag.idPaciente = pa.id \n" +
            "WHERE pr.id = :idProfissional and ag.data = :data")
    Page<ListaAgendamentoDTO> findByAgendaProfissional(@Param("idProfissional") Long idProfissional, LocalDate data, Pageable pageable);


//Busca agendamento por paciente
    @Query("SELECT NEW br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO(ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.data, ag.hora, ag.confirmada) FROM \n" +
            "Agendamentos ag INNER JOIN Profissionais pr ON\n" +
            "ag.idProfissional = pr.id \n" +
            "INNER JOIN Pacientes pa ON\n" +
            "ag.idPaciente = pa.id \n" +
            "WHERE pa.id = :idPaciente")
    Page<ListaAgendamentoDTO> findByIdPaciente(Long idPaciente, Pageable pageable);

    // Consultar agendamentos por data
    @Query("SELECT NEW br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO(ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.data, ag.hora, ag.confirmada) FROM \n" +
            "Agendamentos ag INNER JOIN Profissionais pr ON\n" +
            "ag.idProfissional = pr.id \n" +
            "INNER JOIN Pacientes pa ON\n" +
            "ag.idPaciente = pa.id \n" +
            "WHERE ag.data = :data")

    Page<ListaAgendamentoDTO> findByDataAgendamento(LocalDate data, Pageable pageable);



    @Query("SELECT NEW br.com.clinica.api.domain.agenda.DTOs.AgendaDetalheDTO( \n" +
            "ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.data, ag.hora, ag.observacao, ag.confirmada) \n" +
            " FROM Agendamentos ag INNER JOIN Profissionais pr ON \n" +
            "ag.idProfissional = pr.id \n " +
            "INNER JOIN Pacientes pa ON \n" +
            "ag.idPaciente = pa.id \n" +
            "WHERE ag.id = :idAgenda")
    AgendaDetalheDTO findByidAgenda(@Param("idAgenda") Long idAgenda);
}
