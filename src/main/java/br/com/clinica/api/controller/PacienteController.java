package br.com.clinica.api.controller;

import br.com.clinica.api.domain.pacientes.DadosCadastroPaciente;
import br.com.clinica.api.domain.pacientes.Paciente;
import br.com.clinica.api.domain.pacientes.PacienteRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public Paciente incluir(@RequestBody @Valid DadosCadastroPaciente dados) {
        return repository.save(new Paciente(dados));
    }

    @GetMapping("/detalhe_paciente/{id}")
    public Optional<Paciente> getId(@RequestParam("id") Long id) {
        return repository.findById(id);
    }


    @PutMapping
    @Transactional
    public Paciente alterarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        return repository.save(new Paciente(dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteId(@RequestParam("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping
//    public ResponseEntity<Page<ListaPacienteDTO>> getAll(Pageable paginacao) {
//        var page = repository.findAllByAtivoTrue(paginacao).map(ListaPacienteDTO::new);
//        return ResponseEntity.ok(page);
//        //return paciente.findAll(paginacao).map(ListaPacienteDTO::new);
//    }

}
