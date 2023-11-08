package br.com.clinica.api.controller;


import br.com.clinica.api.domain.agenda.Agendamento;
import br.com.clinica.api.domain.agenda.AgendamentoRepository;
import br.com.clinica.api.domain.agenda.DTOs.DadosAgendamentoDTO;
import br.com.clinica.api.domain.agenda.DTOs.ListaAgendamentoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity criarAgendamento(@RequestBody @Valid DadosAgendamentoDTO dados, UriComponentsBuilder uriBuilder) {
        var agenda = new Agendamento(dados);
        var agendado = repository.save(agenda);
        var uri = uriBuilder.path("/agendamentos/detalhe_agenda/{id}").buildAndExpand(agendado.getId()).toUri();
        return ResponseEntity.created(uri).body(agendado);
    }


    /*@PutMapping
    @Transactional
    public Agendamento alterarPaciente(DadosAgendamentoDTO dados) {
        return agendamento.save(new Agendamento());
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteId(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/agenda_profissional/{id}{data}")
    public ResponseEntity getAgendaProfissional(Pageable paginacao, @RequestParam("id") Long id, @RequestParam("data") LocalDate data) {
        var agenda = repository.findByAgendaProfissional(id, data, paginacao).stream().toList();
        return ResponseEntity.ok(agenda);

    }

    @GetMapping("/detalhe_agenda/{id}")
    public ResponseEntity detalheAgenda(@PathVariable Long id) {
        var agenda = repository.findByidAgenda(id);
        return ResponseEntity.ok(agenda);
    }

    @GetMapping("/agenda_paciente/{id}")
    public ResponseEntity<List<ListaAgendamentoDTO>> getAgendaProfissional(Pageable paginacao, @RequestParam("id") Long id) {
       var agendamentos =  repository.findByIdPaciente(id, paginacao).stream().toList();
        return ResponseEntity.ok(agendamentos);

    }

    @GetMapping("/agenda_data")
    public ResponseEntity<List<ListaAgendamentoDTO>> getId(@RequestParam("data") LocalDate data, Pageable paginacao) {
        var agenamentos = repository.findByDataAgendamento(data, paginacao).stream().toList();
        return ResponseEntity.ok(agenamentos);
    }

}
