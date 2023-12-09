package br.com.clinica.api.controller;


import br.com.clinica.api.domain.agenda.services.AgendarService;
import br.com.clinica.api.domain.agenda.AgendamentoRepository;
import br.com.clinica.api.domain.agenda.DTOs.DadosAgendamentoDTO;
import br.com.clinica.api.domain.agenda.services.ListarAgendamentos;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;

@RestController
@RequestMapping("/agendamentos")
@SecurityRequirement(name = "bearer-key")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;
    @Autowired
    private AgendarService service;

    @Autowired
    ListarAgendamentos lista;


    @PostMapping
    @Transactional
    public ResponseEntity marcarAgenda(@RequestBody @Valid DadosAgendamentoDTO dados, UriComponentsBuilder uriBuilder) {
        var agendamento = service.agendar(dados);
        var uri = uriBuilder.path("/agendamentos/detalhe_agenda/{id}").buildAndExpand(agendamento.id()).toUri();
        return ResponseEntity.created(uri).body(agendamento);
    }


    @GetMapping("/agenda_profissional/{id}{data}")
    public ResponseEntity agendaProfissional(Pageable paginacao, @RequestParam("id") Long id, @RequestParam("data") LocalDate data) {
        var agenda = lista.listaAgendaProfissional(id, data, paginacao).stream().toList();
        return ResponseEntity.ok(agenda);

    }

    @GetMapping("/agenda_paciente/{id}{data}")
    public ResponseEntity agendaPaciente(Pageable paginacao, @RequestParam("id") Long id, @RequestParam("data") LocalDate data) {
        var agenda = lista.listaAgendaPaciente(id, data, paginacao).stream().toList();
        return ResponseEntity.ok(agenda);

    }

    @GetMapping("/agenda_data")
    public ResponseEntity agendaData(@RequestParam("data") LocalDate data, Pageable paginacao) {
        var agenda = lista.listaAgendaData(data, paginacao).stream().toList();
        return ResponseEntity.ok(agenda);
    }

    @GetMapping("/detalhe_agenda/{id}")
    public ResponseEntity detalheAgenda(@PathVariable Long id) {
        var agenda = repository.findByidAgenda(id);
        return ResponseEntity.ok(agenda);
    }
/*
    @PutMapping
    @Transactional
    public ResponseEntity alterarPaciente(DadosAgendamentoDTO dados) {
        var agenda = service.atualizar(dados);
        return ResponseEntity.ok();
    }
*/
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteId(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
