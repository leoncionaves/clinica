package br.com.clinica.api.controller;

import br.com.clinica.api.domain.profissionais.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("profissionais")
@SecurityRequirement(name = "bearer-key")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;

    @PostMapping
    @Transactional
    public Profissional create(@RequestBody @Valid DadosCadastroProfissional dados) {
        return repository.save(new Profissional(dados));
    }

    //Retorno sem paginação
//    @GetMapping
//    public List<ListaProfissionalDTO> getAll(Pageable paginacao) {
//        return profissional.findAll(paginacao).stream().map(ListaProfissionalDTO::new).toList();
//    }

    //Retorno por paginação
//    @GetMapping
//    public ResponseEntity<Page<ListaProfissionalDTO>> getAll(Pageable paginacao) {
//        var list = repository.findAllByAtivoTrue(paginacao).map(ListaProfissionalDTO::new);
//        return ResponseEntity.ok(list);
//    }


    @GetMapping("/detalhe_profissional/{id}")
    public ResponseEntity getId(@PathVariable Long id) {
        var profissional = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalheCadstroProfissional(profissional));
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
