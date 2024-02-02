package br.com.clinica.api.controller;

import br.com.clinica.api.domain.profissionais.especialidade.DTOs.DadosCadastroEspecialidade;
import br.com.clinica.api.domain.profissionais.especialidade.DTOs.ListaEspecialidadeDTO;
import br.com.clinica.api.domain.profissionais.especialidade.Especialidade;
import br.com.clinica.api.domain.profissionais.especialidade.EspecialidadeRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("espcecialidades")
@SecurityRequirement(name = "bearer-key")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Especialidade> incluir(@RequestBody @Valid DadosCadastroEspecialidade dados) {
        return ResponseEntity.ok(repository.save(new Especialidade(dados)));
    }

    @GetMapping("/detalhe_especialidade/{id}")
    public Optional<Especialidade> getId(@RequestParam("id") Long id) {
        return repository.findById(id);
    }

    @GetMapping
    public ResponseEntity<Page<ListaEspecialidadeDTO>> getAll(Pageable paginacao) {
        var list = repository.findAll(paginacao).map(ListaEspecialidadeDTO::new);
        return ResponseEntity.ok(list);
    }



    @PutMapping
    @Transactional
    public Especialidade alterarEspecialidade(@RequestBody @Valid DadosCadastroEspecialidade dados) {
        return repository.save(new Especialidade(dados));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteId(@RequestParam("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
