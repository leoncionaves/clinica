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
    private AgendamentoRepository agendamento;


    @PostMapping
    @Transactional
    public Agendamento criarAgendamento(Long idProfissional, Long idPaciente, String dataAgendamento, String horaAgendamento, String observacao) {
        Agendamento agenda = new Agendamento(null, idProfissional, idPaciente, LocalDate.parse(dataAgendamento, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.parse(horaAgendamento, DateTimeFormatter.ofPattern("HH:mm:ss")), false, observacao);
        return agendamento.save(agenda);
    }


    /*@PutMapping
    @Transactional
    public Agendamento alterarPaciente(Long id, Long idProfissional, Long idPaciente, String dataAgendamento, String horaAgendamento, String observacao) {
        return agendamento.save(new Agendamento());
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteId(@RequestParam("id") Long id) {
        agendamento.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/agenda_profissional/{id}{data}")
    public List<Agendamento> getAgendaProfissional(Pageable paginacao, @RequestParam("id") Long id,@RequestParam("data") LocalDate data) {
        if (data == null ){data = LocalDate.now();}
        return agendamento.findByIdProfissionalandData(id, data, paginacao).stream().toList();

    }

    @GetMapping("/agenda_paciente/{id}")
    public List<Agendamento> getAgendaProfissional(Pageable paginacao, @RequestParam("id") Long id) {
        return agendamento.findByIdPaciente(id, paginacao).stream().toList();

    }

    @GetMapping("/agenda_data/{data}")
    public List<Agendamento> getId(Pageable paginacao, @RequestParam("data") LocalDate data) {
        return agendamento.findByDataAgendamento(data, paginacao).stream().toList();
    }

}
