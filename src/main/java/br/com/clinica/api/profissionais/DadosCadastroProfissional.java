package br.com.clinica.api.profissionais;

import br.com.clinica.api.model.pessoa.PessoaDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfissional(
        PessoaDTO pessoa,
        @NotNull
        Especialidade especialidade,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        Boolean ativo) {}
