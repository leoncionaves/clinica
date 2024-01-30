package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.especialidade.Especialidade;
import br.com.clinica.api.domain.pessoa.PessoaDTO;

public record DadosAtualizacaoProfissional(

        Long id,
        PessoaDTO pessoa,

        Especialidade especialidade,

        //@NotBlank
        //@Pattern(regexp = "\\d{4,6}")
        String registroConselho,
        Boolean ativo) {
}
