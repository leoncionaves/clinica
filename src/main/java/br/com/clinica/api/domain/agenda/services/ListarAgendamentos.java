package br.com.clinica.api.domain.agenda.services;

import br.com.clinica.api.domain.agenda.AgendamentoRepository;
import br.com.clinica.api.domain.agenda.DTOs.AgendaDetalheDTO;
import br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO;
import br.com.clinica.api.domain.pacientes.PacienteRepository;
import br.com.clinica.api.domain.profissionais.ProfissionalRepository;
import br.com.clinica.api.infra.exception.ValidarExcecoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ListarAgendamentos {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public Page<ListaAgendamentoDTO> listaAgendaProfissional(Long id, LocalDate data, Pageable paginacao) {
        if (!profissionalRepository.existsById(id)) {
            throw new ValidarExcecoes("ID informado não existe na base de dados!");
        }
        return agendamentoRepository.findByAgendaProfissional(id, data, paginacao);
    }

    public Page<ListaAgendamentoDTO> listaAgendaPaciente(Long id, LocalDate data, Pageable paginacao) {
        if (!pacienteRepository.existsById(id)) {
            throw new ValidarExcecoes("ID informado não existe na base de dados!");
        }
        return agendamentoRepository.findByAgendaPaciente(id, data, paginacao);
    }

    public Page<ListaAgendamentoDTO> listaAgendaData(LocalDate data, Pageable paginacao) {
        if (data == null) {
            throw new ValidarExcecoes("Data inválida!");
        }
        return agendamentoRepository.findByData(data, paginacao);
    }

    public AgendaDetalheDTO detalheAgenda(Long id) {
        return agendamentoRepository.findByidAgenda(id);
    }
}
