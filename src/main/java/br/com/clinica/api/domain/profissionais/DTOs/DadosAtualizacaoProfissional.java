package br.com.clinica.api.domain.profissionais.DTOs;

import br.com.clinica.api.domain.pessoa.PessoaDTO;
import br.com.clinica.api.domain.profissionais.especialidade.Especialidade;

public record DadosAtualizacaoProfissional(

        Long id,
        PessoaDTO pessoa,

        Especialidade especialidade,

        //@NotBlank
        //@Pattern(regexp = "\\d{4,6}")
        String registroConselho,
        Boolean ativo) {
}
