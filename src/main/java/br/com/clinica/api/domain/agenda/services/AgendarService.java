package br.com.clinica.api.domain.agenda.services;

import br.com.clinica.api.domain.agenda.Agendamento;
import br.com.clinica.api.domain.agenda.AgendamentoRepository;
import br.com.clinica.api.domain.agenda.DTOs.AgendaDetalheDTO;
import br.com.clinica.api.domain.agenda.DTOs.DadosAgendamentoDTO;
import br.com.clinica.api.domain.agenda.validacao.VaidadorAgendamento;
import br.com.clinica.api.domain.pacientes.PacienteRepository;
import br.com.clinica.api.domain.profissionais.ProfissionalRepository;
import br.com.clinica.api.infra.exception.ValidarExcecoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendarService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<VaidadorAgendamento> validador;

    public AgendaDetalheDTO agendar(DadosAgendamentoDTO dados){
        /*
        * Espaço para validações/regras de negócio
        * */
        if(!profissionalRepository.existsById(dados.idProfissional())) {
            throw new ValidarExcecoes("ID informado para profissional não existe na base de dados!");
        }

        if(!profissionalRepository.existsById(dados.idPaciente())) {
            throw new ValidarExcecoes("ID informado para paciente não existe na base de dados!");
        }

        validador.forEach(v-> v.validar(dados));

        var profissional = profissionalRepository.getReferenceById(dados.idProfissional());
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var agendamento = new Agendamento(null, profissional, paciente, dados.data(), dados.hora(),dados.confirmada(), dados.observacao());
        agendamentoRepository.save(agendamento);
        return new AgendaDetalheDTO(agendamento);
    }
}
