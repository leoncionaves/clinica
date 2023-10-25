package br.com.clinica.api.profissionais;

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
    private ProfissionalRepository profissional;

    @PostMapping
    @Transactional
    public Profissional create(@RequestBody @Valid DadosCadastroProfissional dados) {
        return profissional.save(new Profissional(dados));
    }

    //Retorno sem paginação
//    @GetMapping
//    public List<ListaProfissionalDTO> getAll(Pageable paginacao) {
//        return profissional.findAll(paginacao).stream().map(ListaProfissionalDTO::new).toList();
//    }

    //Retorno por paginação
    @GetMapping
    public Page<ListaProfissionalDTO> getAll(Pageable paginacao) {
        return profissional.findAllByAtivoTrue(paginacao).map(ListaProfissionalDTO::new);
    }


    @GetMapping("/detalhe_profissional/{id}")
    public Optional<Profissional> getId(@RequestParam("id") Long id) {
        return profissional.findById(id);
    }

    @PutMapping
    @Transactional
    public Profissional update(@RequestBody @Valid DadosCadastroProfissional dados) {
        return profissional.save(new Profissional(dados));

    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deleteId(@RequestParam("id") Long id) {
        profissional.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
