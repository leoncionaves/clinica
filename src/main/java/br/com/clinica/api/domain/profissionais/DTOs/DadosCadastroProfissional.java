package br.com.clinica.api.domain.profissionais.DTOs;

import br.com.clinica.api.domain.pessoa.PessoaDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record DadosCadastroProfissional(
        PessoaDTO pessoa,
        //@NotNull
        List<Long> idEspecialidade,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String registroConselho
      ) {}
