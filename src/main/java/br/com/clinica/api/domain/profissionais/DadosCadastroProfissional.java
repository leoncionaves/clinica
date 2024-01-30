package br.com.clinica.api.domain.profissionais;

import br.com.clinica.api.domain.pessoa.PessoaDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfissional(
        PessoaDTO pessoa,
        @NotNull
        Long idEspecialidade,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String registroConselho
      ) {}
