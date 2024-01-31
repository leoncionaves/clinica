package br.com.clinica.api.domain.profissionais.DTOs;

import br.com.clinica.api.domain.especialidade.Especialidade;
import br.com.clinica.api.domain.pessoa.Endereco;
import br.com.clinica.api.domain.profissionais.Profissional;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"especialidadeList"})
public record DetalheCadstroProfissional(Long id,
                                         String nome,
                                         String telefone,
                                         String email,
                                         Endereco endereco,
                                         String crm,
                                         Boolean ativo,
                                         List<Especialidade> especialidade) {

    public DetalheCadstroProfissional(Profissional profissional) {
        this(profissional.getId(),
                profissional.getNome(),
                profissional.getTelefone(),
                profissional.getEmail(),
                profissional.getEndereco(),
                profissional.getRegistroConselho(),
                profissional.getAtivo(),
                profissional.getEspecialidadeList());
    }
}
