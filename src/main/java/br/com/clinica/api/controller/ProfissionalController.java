package br.com.clinica.api.controller;

import br.com.clinica.api.domain.profissionais.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @PostMapping
    @Transactional
    public Profissional create(@RequestBody @Valid DadosCadastroProfissional dados) {
        return profissionalRepository.save(new Profissional(dados));
    }

    //Retorno sem paginação
//    @GetMapping
//    public List<ListaProfissionalDTO> getAll(Pageable paginacao) {
//        return profissional.findAll(paginacao).stream().map(ListaProfissionalDTO::new).toList();
//    }

    //Retorno por paginação
    @GetMapping
    public ResponseEntity<Page<ListaProfissionalDTO>> getAll(Pageable paginacao) {
        var list = profissionalRepository.findAllByAtivoTrue(paginacao).map(ListaProfissionalDTO::new);
        return ResponseEntity.ok(list);
    }


    @GetMapping("/detalhe_profissional/{id}")
    public Optional<Profissional> getId(@RequestParam("id") Long id) {
        return profissionalRepository.findById(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DadosAtualizacaoProfissional dados) {
        var profissional = profissionalRepository.getReferenceById(dados.id());
        profissional.atualizaCadastro(dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteId(@RequestParam("id") Long id) {
        profissionalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
