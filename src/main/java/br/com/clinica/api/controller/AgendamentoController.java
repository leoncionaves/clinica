package br.com.clinica.api.controller;


import br.com.clinica.api.domain.agenda.Agendamento;
import br.com.clinica.api.domain.agenda.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;


    @PostMapping
    @Transactional
    public Agendamento criarAgendamento(Long idProfissional, Long idPaciente, String dataAgendamento, String horaAgendamento, String observacao) {
        Agendamento agenda = new Agendamento(null, idProfissional, idPaciente, LocalDate.parse(dataAgendamento, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.parse(horaAgendamento, DateTimeFormatter.ofPattern("HH:mm:ss")), false, observacao);
        return repository.save(agenda);
    }


    /*@PutMapping
    @Transactional
    public Agendamento alterarPaciente(Long id, Long idProfissional, Long idPaciente, String dataAgendamento, String horaAgendamento, String observacao) {
        return agendamento.save(new Agendamento());
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteId(@RequestParam("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/agenda_profissional/{id}{data}")
    public ResponseEntity<List<Agendamento>> getAgendaProfissional(Pageable paginacao, @RequestParam("id") Long id,@RequestParam("data") LocalDate data) {
        if (data == null ) data = LocalDate.now();
        var agenda = repository.findByIdProfissionalandData(id, data, paginacao).stream().toList();
        return ResponseEntity.ok(agenda);

    }

    @GetMapping("/agenda_paciente/{id}")
    public List<Agendamento> getAgendaProfissional(Pageable paginacao, @RequestParam("id") Long id) {
        return repository.findByIdPaciente(id, paginacao).stream().toList();

    }

    @GetMapping("/agenda_data")
    public ResponseEntity<List<Agendamento>> getId(@RequestParam("data") LocalDate data, Pageable paginacao) {
        if (data == null ) data = LocalDate.now();
        var agenamento = repository.findByDataAgendamento(data, paginacao).stream().toList()
        return ResponseEntity.ok(new AgendamentoData(agenamento));
    }

}
