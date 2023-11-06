package br.com.clinica.api.pacientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository paciente;

    @PostMapping
    @Transactional
    public Paciente incluir(@RequestBody @Valid DadosCadastroPaciente dados) {
        return paciente.save(new Paciente(dados));
    }

    @GetMapping("/detalhe_paciente/{id}")
    public Optional<Paciente> getId(@RequestParam("id") Long id) {
        return paciente.findById(id);
    }


    @PutMapping
    @Transactional
    public Paciente alterarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        return paciente.save(new Paciente(dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteId(@RequestParam("id") Long id) {
        paciente.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ListaPacienteDTO>> getAll(Pageable paginacao) {
        var page = paciente.findAllByAtivoTrue(paginacao).map(ListaPacienteDTO::new);
        return ResponseEntity.ok(page);
        //return paciente.findAll(paginacao).map(ListaPacienteDTO::new);
    }

}
