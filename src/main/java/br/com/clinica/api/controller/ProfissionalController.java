package br.com.clinica.api.controller;

import br.com.clinica.api.domain.profissionais.DTOs.DadosAtualizacaoProfissional;
import br.com.clinica.api.domain.profissionais.DTOs.DadosCadastroProfissional;
import br.com.clinica.api.domain.profissionais.DTOs.DetalheCadstroProfissional;
import br.com.clinica.api.domain.profissionais.DTOs.ListaProfissionalDTO;
import br.com.clinica.api.domain.profissionais.Profissional;
import br.com.clinica.api.domain.profissionais.ProfissionalRepository;
import br.com.clinica.api.domain.profissionais.service.CadastroProfissionalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("profissionais")
@SecurityRequirement(name = "bearer-key")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;

    @Autowired
    private CadastroProfissionalService service;

    @PostMapping
    @Transactional
    public Profissional create(@RequestBody @Valid DadosCadastroProfissional dados) {
        ;
        return service.cadastrar(dados);
    }

    @GetMapping
    public ResponseEntity<Page<ListaProfissionalDTO>> getAll(Pageable paginacao) {
        var list = repository.findAll(paginacao).map(ListaProfissionalDTO::new);
        return ResponseEntity.ok(list);
    }


    @GetMapping("/detalhe_profissional/{id}")
    public ResponseEntity getId(@PathVariable Long id) {
        if (id != null) {
            var profissional = repository.getReferenceById(id);
            return ResponseEntity.ok(new DetalheCadstroProfissional(profissional));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizacaoProfissional dados) {
        var profissional = repository.getReferenceById(dados.id());
        profissional.atualizaCadastro(dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteId(@RequestParam("id") Long id) {
        var profissional = repository.getReferenceById(id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
