package br.com.clinica.api.agenda;

import br.com.clinica.api.pacientes.Paciente;
import br.com.clinica.api.profissionais.Profissional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;

public interface AgendamentoRepository extends JpaRepository <Agendamento, Long> {

    //Busca agendamento por profissiona/data
    @Query("SELECT ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.dataAgendamento, ag.horaAgendamento FROM \n" +
            "Agendamentos ag INNER JOIN Profissionais pr ON\n" +
            "ag.idProfissional = pr.id \n" +
            "INNER JOIN Pacientes pa ON\n" +
            "ag.idPaciente = pa.id \n" +
            "WHERE pr.id = :idProfissional and ag.dataAgendamento = :data")
    Page<Agendamento> findByIdProfissionalandData(@Param("idProfissional") Long idProfissional, LocalDate data, Pageable pageable);


//Busca agendamento por paciente
    @Query("SELECT ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.dataAgendamento, ag.horaAgendamento FROM \n" +
            "Agendamentos ag INNER JOIN Profissionais pr ON\n" +
            "ag.idProfissional = pr.id \n" +
            "INNER JOIN Pacientes pa ON\n" +
            "ag.idPaciente = pa.id \n" +
            "WHERE pa.id = :idPaciente")
    Page<Agendamento> findByIdPaciente(Long idPaciente, Pageable pageable);

    @Query("SELECT ag.id, pr.pessoa.nome, pa.pessoa.nome, ag.dataAgendamento, ag.horaAgendamento FROM \n" +
            "Agendamentos ag INNER JOIN Profissionais pr ON\n" +
            "ag.idProfissional = pr.id \n" +
            "INNER JOIN Pacientes pa ON\n" +
            "ag.idPaciente = pa.id \n" +
            "WHERE ag.dataAgendamento = :dataAgendamento")
    // Consultar agendamentos por data
    Page<Agendamento> findByDataAgendamento(LocalDate dataAgendamento, Pageable pageable);
}
