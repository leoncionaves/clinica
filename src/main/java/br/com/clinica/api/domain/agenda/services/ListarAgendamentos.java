package br.com.clinica.api.domain.agenda.services;

import org.springframework.stereotype.Service;

@Service
public class ListarAgendamentos {
/*
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
    }*/
}
