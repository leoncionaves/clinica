package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.pessoa.Endereco;
import br.com.clinica.api.domain.pessoa.Pessoa;
import br.com.clinica.api.domain.pessoa.PessoaDTO;

public record DetalheCadstroProfissional(Long id, Pessoa pessoa, Especialidade especialidade, String crm, Boolean ativo) {

    public DetalheCadstroProfissional(Profissional profissional) {
        this(profissional.getId(),
                profissional.getPessoa(),
                profissional.getEspecialidade(),
                profissional.getCrm(),
                profissional.getAtivo());
    }
}
